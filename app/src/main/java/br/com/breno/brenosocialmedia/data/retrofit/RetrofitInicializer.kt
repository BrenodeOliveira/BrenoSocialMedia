package br.com.breno.brenosocialmedia.data.retrofit

import br.com.breno.brenosocialmedia.data.service.PostsService
import br.com.breno.brenosocialmedia.data.service.UsersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {
     private val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    fun postsService() = retrofit.create(PostsService::class.java)

    fun usersService() = retrofit.create(UsersService::class.java)
}