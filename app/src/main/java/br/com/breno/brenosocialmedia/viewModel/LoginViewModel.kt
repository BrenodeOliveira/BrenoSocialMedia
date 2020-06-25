package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.data.model.Users
import br.com.breno.brenosocialmedia.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val postsLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun checkUser(username: String) {
        if (username.isNotEmpty()) {
            ApiService.usersService.getUsers().enqueue(object : Callback<ArrayList<Users>> {
                override fun onResponse(
                    call: Call<ArrayList<Users>>,
                    response: Response<ArrayList<Users>>
                ) {
                    //When API response is above 200ms
                    if (response.isSuccessful) {
                        response.body()?.let {
                            for (result in it) {
                                if (result.username.equals(username)) {
                                    postsLiveData.value = true
                                }
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<Users>>, t: Throwable) {

                }
            })
        } else if (username.isNullOrEmpty()){
            postsLiveData.value = false
        }

    }

}

