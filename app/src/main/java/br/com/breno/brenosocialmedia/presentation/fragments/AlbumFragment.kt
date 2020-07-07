package br.com.breno.brenosocialmedia.presentation.fragments

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.adapter.AlbumAdapter
import br.com.breno.brenosocialmedia.presentation.activities.GaleriaActivity
import br.com.breno.brenosocialmedia.viewModel.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_album.*

class AlbumFragment: Fragment() {

    private lateinit var viewModel: AlbumViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)

        val titulo = viewModel.getTitleName(requireContext().applicationContext)

        setCollapsing(titulo)
        observers()

        viewModel.fillRecycler()
    }

    private fun observers() {
        viewModel.booksLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {albums->
                with(recyclerAlbums) {
                    layoutManager =
                        LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                    layoutManager = GridLayoutManager(requireContext(), 2)
                    adapter = AlbumAdapter(albums) {
                        val intent = Intent(requireContext(), GaleriaActivity::class.java)

                        startActivity(intent)
                    }
                }
            }
        })
    }

    private fun setCollapsing(titulo: String?) {
        val states = arrayOf(intArrayOf(android.R.attr.state_enabled))
        val colors = intArrayOf(Color.TRANSPARENT)
        val myList = ColorStateList(states, colors)

        collapsingAlbum.apply {
            setCollapsedTitleTextColor(Color.WHITE)
            title = titulo
            setExpandedTitleTextColor(myList)
        }
    }
}