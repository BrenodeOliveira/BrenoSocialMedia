package br.com.breno.brenosocialmedia.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.breno.brenosocialmedia.data.APIService
import br.com.breno.brenosocialmedia.data.response.UserResponse
import br.com.breno.brenosocialmedia.model.Users
import retrofit2.Callback

class LoginViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<List<Users>> = MutableLiveData()

    fun checkUser() {
        APIService.userService.loginUser().enqueue(object : Callback<UserResponse>)
    }

}