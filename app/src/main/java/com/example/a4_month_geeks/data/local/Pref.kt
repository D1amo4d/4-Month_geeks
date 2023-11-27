package com.example.a4_month_geeks.data.local

import android.content.Context

class Pref(private val context:Context) {

    private val pref=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    fun onShowed():Boolean{
        return pref.getBoolean(SHOWED_KEY,false)
    }
    fun onBoardingShpw(){
        pref.edit().putBoolean(SHOWED_KEY,true).apply()//edit это специальный код если перевести то это отредактировать

    }

    companion object{
        const val PREF_NAME="pref.name"
        const val SHOWED_KEY="showed.key"
    }
}