package br.com.breno.brenosocialmedia.constants.userConstant

import android.content.Context
import br.com.breno.brenosocialmedia.constants.Constants
import br.com.breno.brenosocialmedia.constants.Constants.Constants.userDB
import br.com.breno.brenosocialmedia.data.model.Users

class UsuarioUtils {

    companion object {
        lateinit var usuario: Users

        fun populaUsuario(context: Context){
            usuario = SharedPreferencesUtils
                .buscaObjeto(context, userDB, Constants.Constants.userObjeto, Users::class.java)
        }
    }
}