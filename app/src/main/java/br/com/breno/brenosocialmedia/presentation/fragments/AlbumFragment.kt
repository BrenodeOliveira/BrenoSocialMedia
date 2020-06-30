package br.com.breno.brenosocialmedia.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.viewModel.AlbumViewModel

class AlbumFragment: Fragment() {

    private lateinit var viewModel: AlbumViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }
}