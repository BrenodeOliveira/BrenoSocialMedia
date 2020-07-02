package br.com.breno.brenosocialmedia.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.adapter.PostsAdapter
import br.com.breno.brenosocialmedia.data.model.Posts
import br.com.breno.brenosocialmedia.viewModel.PostsViewModel
import kotlinx.android.synthetic.main.fragment_posts.*

class PostsFragment: Fragment() {

    private lateinit var viewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)

    }

    fun configuraRecycler(posts: ArrayList<Posts>){
        recyclerPosts.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PostsAdapter(posts)
        }
    }
}