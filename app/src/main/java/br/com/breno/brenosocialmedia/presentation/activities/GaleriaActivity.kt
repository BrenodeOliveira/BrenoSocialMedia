package br.com.breno.brenosocialmedia.presentation.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.adapter.GaleriaAdapter
import br.com.breno.brenosocialmedia.viewModel.GaleriaViewModel
import kotlinx.android.synthetic.main.activity_galeria.*

class GaleriaActivity : AppCompatActivity() {

    private lateinit var viewModel: GaleriaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)
        setActionBar(toolbarGaleria)

        viewModel = ViewModelProvider(this).get(GaleriaViewModel::class.java)

        configureToolbar()

        viewModel.fillRecycler()

        observers()
    }

    private fun observers() {
        viewModel.photosLiveData.observe(this, Observer {
            it?.let {photos->
                with(recyclerGaleria) {
                    layoutManager =
                        LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    layoutManager = GridLayoutManager(context, 3)
                    adapter = GaleriaAdapter(photos)
                }
            }
        })
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
