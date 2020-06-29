package br.com.breno.brenosocialmedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.data.model.Posts
import kotlinx.android.synthetic.main.item_posts.view.*

class PostsAdapter (val posts: ArrayList<Posts>): RecyclerView.Adapter<ViewHolderPosts>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPosts {
        return ViewHolderPosts(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_posts,parent,false)
        )
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: ViewHolderPosts, position: Int) {
        var post = posts[position]
        holder.apply {
            tituloItem.text = post.title
            textoItem.text = post.body
        }
    }

}

class ViewHolderPosts(view: View): RecyclerView.ViewHolder(view) {
    val tituloItem = view.tituloPost
    val textoItem = view.textoPost
}