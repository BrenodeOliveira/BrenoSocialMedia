package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import br.com.breno.brenosocialmedia.constants.Constants

class MapsViewModel(application: Application): AndroidViewModel(application) {

    fun getTitleName(context: Context): String? {
        val sharedPreferences = context
            .getSharedPreferences(Constants.Constants.KEY_INFO, Context.MODE_PRIVATE)

        return sharedPreferences.getString(Constants.Constants.KEY_NAME, "")
    }
}