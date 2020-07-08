package br.com.breno.brenosocialmedia.presentation.fragments

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.adapter.PostsAdapter
import br.com.breno.brenosocialmedia.data.model.Posts
import br.com.breno.brenosocialmedia.viewModel.PostsViewModel
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.fragment_posts.*
import kotlinx.android.synthetic.main.item_posts.*

class PostsFragment: Fragment() {

    private lateinit var viewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)

        val titulo = viewModel.getTitleName(requireContext().applicationContext)

        setCollapsing(titulo)
//        fillInfosToolbar()
        observers()

        viewModel.fillRecycler()

    }

//    private fun fillInfosToolbar() {
//
//    }

    private fun observers() {
        viewModel.postsLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {posts ->
                with(recyclerPosts) {
                    layoutManager =
                        LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                    adapter = PostsAdapter(posts)
                }
            }
        })
    }

    private fun setCollapsing(titulo: String?) {
        val states = arrayOf(intArrayOf(android.R.attr.state_enabled))
        val colors = intArrayOf(Color.TRANSPARENT)
        val myList = ColorStateList(states, colors)

        collapsingPosts.apply {
            setCollapsedTitleTextColor(Color.WHITE)
            title = titulo
            setExpandedTitleTextColor(myList)
        }
    }
}