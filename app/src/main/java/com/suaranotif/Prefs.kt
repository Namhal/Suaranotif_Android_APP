package com.suaranotif

import android.content.Context

object Prefs {
    private fun sp(c: Context) = c.getSharedPreferences("cfg", Context.MODE_PRIVATE)
    fun enabled(c: Context) = sp(c).getBoolean("enabled", true)
    fun setEnabled(c: Context, v: Boolean) = sp(c).edit().putBoolean("enabled", v).apply()
    // 0 = default (bawaan aplikasi), 1 = dibacakan, 2 = suara sendiri
    fun mode(c: Context, pkg: String) = sp(c).getInt("m_$pkg", 0)
    fun setMode(c: Context, pkg: String, m: Int) = sp(c).edit().putInt("m_$pkg", m).apply()
    fun uri(c: Context, pkg: String): String? = sp(c).getString("u_$pkg", null)
    fun setUri(c: Context, pkg: String, u: String?) = sp(c).edit().putString("u_$pkg", u).apply()
}
