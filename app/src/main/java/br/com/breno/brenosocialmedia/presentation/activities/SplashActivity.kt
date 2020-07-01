package br.com.breno.brenosocialmedia.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.viewModel.LoginViewModel
import br.com.breno.brenosocialmedia.viewModel.SplashViewModel

import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        viewModel.checkUserEntry(this)

        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)

                    viewModel.screenLiveData.observe(this@SplashActivity, Observer {
                        
                    })
                    startActivity(Intent(baseContext, LoginActivity::class.java))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

}