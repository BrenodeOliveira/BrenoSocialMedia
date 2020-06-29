package br.com.breno.brenosocialmedia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.data.model.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumAdapter(val albums: ArrayList<Album>): RecyclerView.Adapter<ViewHolderAlbum>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAlbum {
        val viewHolder =  ViewHolderAlbum(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_album, parent, false)
        )

        context = parent.context

        return viewHolder
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: ViewHolderAlbum, position: Int) {
        val album = albums[position]
        holder.apply {
            tituloItem.text = album.title
        }

        val arrayListString = arrayListOf(
            "https://via.placeholder.com/150/771796",
            "https://via.placeholder.com/150/e9603b",
            "https://via.placeholder.com/150/e9b68",
            "https://via.placeholder.com/150/1adbcb",
            "https://via.placeholder.com/150/d28152",
            "https://via.placeholder.com/150/3c2446",
            "https://via.placeholder.com/150/c01edd",
            "https://via.placeholder.com/150/ab5be6",
            "https://via.placeholder.com/150/549689",
            "https://via.placeholder.com/150/6b1cf4",
            "https://via.placeholder.com/150/5cc01d",
            "https://via.placeholder.com/150/776d09"
        )

        Picasso.get()
            .load(arrayListString[position])
            .fit()
            .centerCrop()
            .into(holder.imagemItem)
    }
}

class ViewHolderAlbum(view: View) : RecyclerView.ViewHolder(view) {
    val imagemItem = view.imagemAlbum
    val tituloItem = view.tituloAlbum
}