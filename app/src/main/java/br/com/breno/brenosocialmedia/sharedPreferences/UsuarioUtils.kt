package br.com.breno.brenosocialmedia.sharedPreferences

import android.content.Context
import br.com.breno.brenosocialmedia.constants.Constants
import br.com.breno.brenosocialmedia.data.model.Users

class UsuarioUtils {
    companion object {
        lateinit var usuario: Users

        fun userPopule(context: Context) {
            usuario = SharedPreferencesUtils
                .searchObject(context, Constants.Constants.userDB,
                    Constants.Constants.userObjeto, Users::class.java)
        }
    }
}