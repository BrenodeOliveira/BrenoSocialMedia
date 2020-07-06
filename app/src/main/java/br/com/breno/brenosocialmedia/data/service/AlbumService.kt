package br.com.breno.brenosocialmedia.data.service

import br.com.breno.brenosocialmedia.data.model.Album
import retrofit2.Call
import retrofit2.http.GET

interface AlbumService {
    @GET("albums")
    fun getAlbums() : Call<ArrayList<Album>>
}