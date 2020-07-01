package br.com.breno.brenosocialmedia.sharedPreferences

import android.content.Context
import com.google.gson.Gson

object SharedPreferencesUtils {
    fun <T> searchObject(context: Context, sharedKey: String, objetoKey: String, clazz: Class<T>): T {
        val sharedPreferences =
            context.getSharedPreferences(sharedKey, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString(objetoKey, "")
        val objeto = gson.fromJson<T>(json, clazz)
        return objeto
    }
}