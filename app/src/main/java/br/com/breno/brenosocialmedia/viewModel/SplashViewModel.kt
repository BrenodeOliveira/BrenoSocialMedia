package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.constants.Constants

class SplashViewModel(application: Application): AndroidViewModel(application) {

    val screenLiveData : MutableLiveData<Int> = MutableLiveData()

    fun checkUserEntry(context: Context) {
        val sharedPreferences = context
            .getSharedPreferences(Constants.Constants.KEY_INFO, Context.MODE_PRIVATE)

        val entry = sharedPreferences.getString(Constants.Constants.KEY_NAME, "")

        if (entry.isNullOrBlank()) {
            screenLiveData.value = 0
        } else {
            screenLiveData.value = 1
        }
    }
}