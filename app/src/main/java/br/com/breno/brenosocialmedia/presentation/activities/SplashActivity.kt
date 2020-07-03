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

        var tela: Int = 0

        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        viewModel.checkUserEntry(this)

        viewModel.getUserLogged().observe(this, Observer {
            if (it) {
                tela = 1
            }
        })

        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)

                    if (tela == 0) {
                        startActivity(Intent(baseContext, LoginActivity::class.java))
                    } else {
                        startActivity(Intent(baseContext, HomeActivity::class.java))
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

}