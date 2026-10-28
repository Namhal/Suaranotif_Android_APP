package com.suaranotif

import android.app.Notification
import android.content.ComponentName
import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.PowerManager
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.speech.tts.TextToSpeech
import java.util.Locale

class NotifService : NotificationListenerService(), TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var ready = false
    private var player: MediaPlayer? = null
    private var lastKey = ""
    private var lastTime = 0L

    private val attrs = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_MEDIA)
        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
        .build()

    override fun onCreate() {
        super.onCreate()
        tts = TextToSpeech(this, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.language = Locale("id", "ID")
            tts?.setAudioAttributes(attrs)
            ready = true
        }
    }

    override fun onListenerDisconnected() {
        try { requestRebind(ComponentName(this, NotifService::class.java)) } catch (_: Exception) {}
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (!Prefs.enabled(this)) return
        val pkg = sbn.packageName
        if (pkg == packageName) return
        val n = sbn.notification ?: return
        if (n.flags and Notification.FLAG_GROUP_SUMMARY != 0) return
        if (sbn.isOngoing) return
        val mode = Prefs.mode(this, pkg)
        if (mode == 0) return

        val ex = n.extras
        val title = ex.getCharSequence(Notification.EXTRA_TITLE)?.toString() ?: ""
        val text = (ex.getCharSequence(Notification.EXTRA_BIG_TEXT)
            ?: ex.getCharSequence(Notification.EXTRA_TEXT))?.toString() ?: ""
        val msg = "$title. $text".trim().trim('.').trim()
        if (msg.isEmpty()) return

        val now = System.currentTimeMillis()
        val key = pkg + msg
        if (key == lastKey && now - lastTime < 3000) return
        lastKey = key; lastTime = now

        try {
            val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
            pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "suaranotif:w").acquire(20000)
        } catch (_: Exception) {}

        val u = Prefs.uri(this, pkg)
        if (mode == 2 && u != null && playFile(u)) return
        if (ready) tts?.speak(msg, TextToSpeech.QUEUE_ADD, null, "n$now")
    }

    private fun playFile(u: String): Boolean = try {
        player?.release()
        player = MediaPlayer().apply {
            setAudioAttributes(attrs)
            setDataSource(this@NotifService, Uri.parse(u))
            setOnPreparedListener { it.start() }
            setOnCompletionListener { it.release() }
            prepareAsync()
        }
        true
    } catch (e: Exception) { false }

    override fun onDestroy() {
        tts?.shutdown()
        player?.release()
        super.onDestroy()
    }
}
