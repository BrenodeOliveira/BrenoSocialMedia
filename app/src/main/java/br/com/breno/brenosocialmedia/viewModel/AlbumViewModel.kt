package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.constants.Constants
import br.com.breno.brenosocialmedia.data.model.Album
import br.com.breno.brenosocialmedia.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumViewModel(application: Application): AndroidViewModel(application) {

    val booksLiveData : MutableLiveData<List<Album>> = MutableLiveData()

    fun fillRecycler() {
        ApiService.albumService.getAlbums().enqueue(object : Callback<ArrayList<Album>>{
            override fun onResponse(
                call: Call<ArrayList<Album>>, response: Response<ArrayList<Album>>) {
                if (response.isSuccessful) {
                    val albuns: MutableList<Album> = mutableListOf()

                    response.body()?.let {albumBodyResponse ->
                        for (result in albumBodyResponse) {
                            val albumList = Album(
                                userId = result.userId,
                                id = result.id,
                                title = result.title
                            )
                            if (result.userId == 2) {
                                break
                            }
                            albuns.add(albumList)
                        }
                    }
                    booksLiveData.value = albuns
                }
            }


            override fun onFailure(call: Call<ArrayList<Album>>, t: Throwable) {

            }
        })
    }

    fun getTitleName(context: Context): String? {
        val sharedPreferences = context
            .getSharedPreferences(Constants.Constants.KEY_INFO, Context.MODE_PRIVATE)

        return sharedPreferences.getString(Constants.Constants.KEY_NAME, "")
    }
}