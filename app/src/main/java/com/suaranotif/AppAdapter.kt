package com.suaranotif

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Item(val pkg: String, val label: String, val icon: Drawable, var mode: Int, var uri: String?)

class AppAdapter(private val onPick: (Item) -> Unit) : RecyclerView.Adapter<AppAdapter.VH>() {
    private var all = listOf<Item>()
    private var shown = listOf<Item>()
    private val modes = listOf("Default (bawaan aplikasi)", "Dibacakan", "Suara sendiri")

    fun submit(l: List<Item>) { all = l; shown = l; notifyDataSetChanged() }
    fun filter(q: String) {
        val s = q.trim()
        shown = if (s.isEmpty()) all else all.filter { it.label.contains(s, true) }
        notifyDataSetChanged()
    }

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val icon: ImageView = v.findViewById(R.id.icon)
        val name: TextView = v.findViewById(R.id.name)
        val mode: Spinner = v.findViewById(R.id.mode)
        val pick: TextView = v.findViewById(R.id.pick)
    }

    override fun onCreateViewHolder(p: ViewGroup, t: Int) =
        VH(LayoutInflater.from(p.context).inflate(R.layout.item_app, p, false))

    override fun getItemCount() = shown.size

    override fun onBindViewHolder(h: VH, pos: Int) {
        val item = shown[pos]
        val ctx = h.itemView.context
        h.name.text = item.label
        h.icon.setImageDrawable(item.icon)
        h.mode.onItemSelectedListener = null
        h.mode.adapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, modes)
        h.mode.setSelection(item.mode, false)
        fun refresh() {
            h.pick.visibility = if (item.mode == 2) View.VISIBLE else View.GONE
            h.pick.text = if (item.uri == null) "Pilih file suara" else "✓ Suara dipilih · ketuk untuk ganti"
        }
        refresh()
        h.pick.setOnClickListener { onPick(item) }
        h.mode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(a: AdapterView<*>?, v: View?, p: Int, id: Long) {
                if (p == item.mode) return
                item.mode = p
                Prefs.setMode(ctx, item.pkg, p)
                refresh()
                if (p == 2 && item.uri == null) onPick(item)
            }
            override fun onNothingSelected(a: AdapterView<*>?) {}
        }
    }
}
