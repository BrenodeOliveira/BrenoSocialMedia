package br.com.breno.brenosocialmedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.data.model.Posts
import kotlinx.android.synthetic.main.item_posts.view.*

class PostsAdapter(private val posts: List<Posts>) : RecyclerView.Adapter<PostsAdapter.ViewHolderPosts>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPosts {
        return ViewHolderPosts(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_posts,parent,false)
        )
    }

    override fun getItemCount(): Int = posts.count()

    override fun onBindViewHolder(viewHolder: ViewHolderPosts, position: Int) {
        viewHolder.bindView(posts[position])
    }

    class ViewHolderPosts(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.tituloPost
        private val body = view.textoPost

        fun bindView(post: Posts) {
            title.text = post.title
            body.text = post.body
        }
    }
}