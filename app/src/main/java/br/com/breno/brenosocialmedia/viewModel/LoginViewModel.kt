package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.constants.Constants
import br.com.breno.brenosocialmedia.constants.userConstant.UsuarioUtils
import br.com.breno.brenosocialmedia.data.model.Users
import br.com.breno.brenosocialmedia.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val postsLiveData: MutableLiveData<Int> = MutableLiveData()

    fun checkUser(username: String) {
        if (username.isNotEmpty()) {
            ApiService.usersService.getUsers().enqueue(object : Callback<ArrayList<Users>> {
                override fun onResponse(
                    call: Call<ArrayList<Users>>,
                    response: Response<ArrayList<Users>>
                ) {
                    //When API response is above 200ms
                    if (response.isSuccessful) {
                        response.body()?.let { listUsers ->
                            for (result in listUsers) {
                                if (result.username.equals(username)) {
                                    //UsuarioUtils.populaUsuario(getApplication())

                                    postsLiveData.value = 1
                                }
                            }
                            //When the username passed doesn't exists show this snack
                            if (postsLiveData.value != 1) {
                                postsLiveData.value = 0
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<Users>>, t: Throwable) {
                    //Only when user is offline is showed this snack
                    postsLiveData.value = 3
                }

            })
        } else {
            //When username comes empty, set number 0 for show the snack bar
            postsLiveData.value = 2
        }
    }

    fun saveUserPreference(context: Context, username: String) {
        val sharedPreferences = context
            .getSharedPreferences(Constants.Constants.KEY_INFO, Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putString(Constants.Constants.KEY_NAME, username)
        editor.apply()
    }

}

