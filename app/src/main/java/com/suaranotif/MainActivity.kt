package com.suaranotif

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.materialswitch.MaterialSwitch
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AppAdapter
    private lateinit var status: TextView
    private var pending: Item? = null
    private var tts: TextToSpeech? = null

    private val picker = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        val item = pending
        if (item != null && uri != null) {
            try {
                contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            } catch (_: Exception) {}
            item.uri = uri.toString()
            Prefs.setUri(this, item.pkg, item.uri)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        status = findViewById(R.id.status)

        val sw = findViewById<MaterialSwitch>(R.id.masterSwitch)
        sw.isChecked = Prefs.enabled(this)
        sw.setOnCheckedChangeListener { _, c -> Prefs.setEnabled(this, c) }

        findViewById<Button>(R.id.btnAccess).setOnClickListener {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }
        findViewById<Button>(R.id.btnBattery).setOnClickListener { askBattery() }
        findViewById<Button>(R.id.btnTest).setOnClickListener { testVoice() }

        adapter = AppAdapter { item ->
            pending = item
            picker.launch(arrayOf("audio/*"))
        }
        val list = findViewById<RecyclerView>(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        findViewById<EditText>(R.id.search).addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { adapter.filter(s?.toString() ?: "") }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })

        Thread {
            val pm = packageManager
            val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
            val items = pm.queryIntentActivities(intent, 0)
                .map { it.activityInfo.packageName }
                .distinct()
                .filter { it != packageName }
                .mapNotNull { p ->
                    try {
                        Item(
                            p,
                            pm.getApplicationLabel(pm.getApplicationInfo(p, 0)).toString(),
                            pm.getApplicationIcon(p),
                            Prefs.mode(this@MainActivity, p),
                            Prefs.uri(this@MainActivity, p)
                        )
                    } catch (e: Exception) { null }
                }
                .sortedWith(compareByDescending<Item> { it.mode > 0 }.thenBy { it.label.lowercase() })
            runOnUiThread { adapter.submit(items) }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        val ok = NotificationManagerCompat.getEnabledListenerPackages(this).contains(packageName)
        status.text = if (ok) "Akses notifikasi aktif ✓" else "Akses notifikasi belum aktif"
    }

    private fun askBattery() {
        val pm = getSystemService(POWER_SERVICE) as PowerManager
        if (pm.isIgnoringBatteryOptimizations(packageName)) {
            Toast.makeText(this, "Sudah bebas dari penghematan baterai ✓", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            startActivity(
                Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, Uri.parse("package:$packageName"))
            )
        } catch (e: Exception) {
            startActivity(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS))
        }
    }

    private fun testVoice() {
        tts?.shutdown()
        tts = TextToSpeech(this) { st ->
            if (st == TextToSpeech.SUCCESS) {
                tts?.language = Locale("id", "ID")
                tts?.speak("Pembayaran diterima sebesar seratus ribu rupiah", TextToSpeech.QUEUE_FLUSH, null, "test")
            }
        }
    }

    override fun onDestroy() {
        tts?.shutdown()
        super.onDestroy()
    }
}
