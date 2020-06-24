package br.com.breno.brenosocialmedia.data.service

import br.com.breno.brenosocialmedia.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface UsersService {
    @GET
    fun getUsers() : Call<ArrayList<Users>>
}