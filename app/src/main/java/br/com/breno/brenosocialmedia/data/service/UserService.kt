package br.com.breno.brenosocialmedia.data.service

import br.com.breno.brenosocialmedia.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("users")
    fun loginUser(@Query("username")username:String) : Call<ArrayList<Users>>
}