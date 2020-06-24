package br.com.breno.brenosocialmedia.viewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.breno.brenosocialmedia.RetrofitInicializer
import br.com.breno.brenosocialmedia.data.service.PostsService
import br.com.breno.brenosocialmedia.model.Posts
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LoginViewModel : ViewModel() {

    val postsLiveData: MutableLiveData<String> = MutableLiveData()

    fun checkUser() {


    }

}

