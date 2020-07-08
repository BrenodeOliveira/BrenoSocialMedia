package br.com.breno.brenosocialmedia.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.viewModel.MapsViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_maps.*

class MapsFragment: Fragment(), OnMapReadyCallback {

    private lateinit var viewModel: MapsViewModel
    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MapsViewModel::class.java)

        map_view.onCreate(savedInstanceState)
        map_view.onResume()

        map_view.getMapAsync(this)

        val titulo = viewModel.getTitleName(requireContext().applicationContext)

        setToolbar(titulo)
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            googleMap = it
        }
    }

    private fun setToolbar(titulo: String?) {
        toolbarMaps.title = titulo
    }
}