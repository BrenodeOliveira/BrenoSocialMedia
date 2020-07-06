package br.com.breno.brenosocialmedia.presentation.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.breno.brenosocialmedia.R
import kotlinx.android.synthetic.main.activity_galeria.*

class GaleriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)

        setActionBar(toolbarGaleria)

        configureToolbar()
    }

    private fun configureToolbar() {
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Breninhooo"
        }
        toolbarGaleria.setTitleTextColor(Color.WHITE)
    }
}
