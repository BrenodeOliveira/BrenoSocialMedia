package br.com.breno.brenosocialmedia.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.breno.brenosocialmedia.R

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
