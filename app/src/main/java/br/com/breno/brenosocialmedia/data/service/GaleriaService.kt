package br.com.breno.brenosocialmedia.data.service

import br.com.breno.brenosocialmedia.data.model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface GaleriaService {

    @GET("photos")
    fun getPhotos(): Call<ArrayList<Photos>>
}