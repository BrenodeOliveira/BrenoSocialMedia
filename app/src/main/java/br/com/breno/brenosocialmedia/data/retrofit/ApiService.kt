package br.com.breno.brenosocialmedia.data.retrofit

import br.com.breno.brenosocialmedia.constants.Contansts
import br.com.breno.brenosocialmedia.data.service.PostsService
import br.com.breno.brenosocialmedia.data.service.UsersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun initRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Contansts.Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val postsService : PostsService = initRetrofit().create(PostsService::class.java)
    val usersService : UsersService = initRetrofit().create(UsersService::class.java)
}