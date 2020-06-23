package br.com.breno.brenosocialmedia.presentation

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import br.com.breno.brenosocialmedia.R

import kotlinx.android.synthetic.main.activity_splash.*
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)

                    startActivity(Intent(baseContext, LoginActivity::class.java))
                } catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

}
