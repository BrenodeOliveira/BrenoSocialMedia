package br.com.breno.brenosocialmedia.data.response

import br.com.breno.brenosocialmedia.model.Users

data class UserResponse(
    val users: ArrayList<Users> = ArrayList(),
    val erro: Throwable? = null
)