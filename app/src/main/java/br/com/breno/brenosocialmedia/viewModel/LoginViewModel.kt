package br.com.breno.brenosocialmedia.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.breno.brenosocialmedia.data.APIService
import br.com.breno.brenosocialmedia.data.response.UserResponse
import br.com.breno.brenosocialmedia.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<List<Users>> = MutableLiveData()

    fun checkUser() {
        APIService.userService.loginUser().enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                TODO("Not yet implemented")
            }

        })
    }

}

