package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.data.model.Photos
import br.com.breno.brenosocialmedia.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GaleriaViewModel(application: Application) : AndroidViewModel(application) {

    val photosLiveData: MutableLiveData<List<Photos>> = MutableLiveData()

    fun fillRecycler() {
        ApiService.galeriaService.getPhotos().enqueue(object : Callback<ArrayList<Photos>>{

            override fun onResponse(
                call: Call<ArrayList<Photos>>, response: Response<ArrayList<Photos>>) {
               if (response.isSuccessful) {

                   val photosList: MutableList<Photos> = mutableListOf()

                   response.body()?.let {photosResponse ->
                       for (result in photosResponse) {
                           val photoResult = Photos(
                               albumId = result.albumId,
                               title = result.title,
                               id = result.id,
                               thumbnailUrl = result.thumbnailUrl,
                               url = result.url
                           )

                           photosList.add(photoResult)
                       }
                   }

                   photosLiveData.value = photosList
               }
            }

            override fun onFailure(call: Call<ArrayList<Photos>>, t: Throwable) {

            }
        })
    }
}