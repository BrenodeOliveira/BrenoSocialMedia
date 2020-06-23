package br.com.breno.brenosocialmedia.data

import br.com.breno.brenosocialmedia.data.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object APIService {

    private fun initRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userService: UserService = initRetrofit().create(UserService::class.java)

}