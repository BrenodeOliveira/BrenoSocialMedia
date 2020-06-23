package br.com.breno.brenosocialmedia.data.calls

import br.com.breno.brenosocialmedia.data.APIService
import br.com.breno.brenosocialmedia.data.extension.callback
import br.com.breno.brenosocialmedia.data.response.UserResponse
import br.com.breno.brenosocialmedia.model.Users
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import java.lang.Exception

object UsersCall {

    lateinit var call: Call<ArrayList<Users>>

    fun checkUserApi(username: String) {
        val call = APIService.userService.loginUser(username)

        call.enqueue(callback({ response ->

            val users = response.body()

            if (users.isNullOrEmpty()) {
                EventBus.getDefault().post(UserResponse(erro = Exception("User not found")))
            } else {
                EventBus.getDefault().post(UserResponse(users))
            }
        }, { throwable ->
            EventBus.getDefault().post(UserResponse(erro = throwable))
        }))
    }
}