package br.com.breno.brenosocialmedia.data.service

import br.com.breno.brenosocialmedia.data.model.Posts
import retrofit2.Call
import retrofit2.http.GET


//EndPoint
interface PostsService {
    @GET("posts")
    fun getPosts() : Call<ArrayList<Posts>>
}