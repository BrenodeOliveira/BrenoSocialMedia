package br.com.breno.brenosocialmedia.data.retrofit

import br.com.breno.brenosocialmedia.constants.Constants
import br.com.breno.brenosocialmedia.data.service.AlbumService
import br.com.breno.brenosocialmedia.data.service.GaleriaService
import br.com.breno.brenosocialmedia.data.service.PostsService
import br.com.breno.brenosocialmedia.data.service.UsersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun initRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val postsService : PostsService = initRetrofit().create(PostsService::class.java)
    val usersService : UsersService = initRetrofit().create(UsersService::class.java)
    val albumService : AlbumService = initRetrofit().create(AlbumService::class.java)
    val galeriaService: GaleriaService = initRetrofit().create(GaleriaService::class.java)
}