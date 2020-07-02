package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.constants.Constants

class SplashViewModel(application: Application): AndroidViewModel(application) {

    private val userLogged = MutableLiveData<Boolean>()

    fun checkUserEntry(context: Context) {
        val sharedPreferences = context
            .getSharedPreferences(Constants.Constants.KEY_INFO, Context.MODE_PRIVATE)

        val entry = sharedPreferences.getString(Constants.Constants.KEY_NAME, "")

        if (entry.isNullOrBlank()) {
            userLogged.postValue(false)
        } else {
            userLogged.postValue(true)
        }
    }

    fun getUserLogged(): LiveData<Boolean> {
        return userLogged
    }
}