package br.com.breno.brenosocialmedia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.data.model.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumAdapter(
    private val albums: List<Album>,
    private val onItemSelectedListener: ((album: Album) -> Unit)
) : RecyclerView.Adapter<AlbumAdapter.ViewHolderAlbum>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAlbum {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return ViewHolderAlbum(itemView, onItemSelectedListener)
    }

    override fun getItemCount(): Int = albums.count()

    override fun onBindViewHolder(viewHolder: ViewHolderAlbum, position: Int) {
        viewHolder.bindView(albums[position])

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
            "https://via.placeholder.com/150/6b1cf4"
        )

        Picasso.get()
            .load(arrayListString[position])
            .fit().centerCrop()
            .into(viewHolder.image)
    }

    class ViewHolderAlbum(
        view: View,
        private val onItemSelectedListener: (album: Album) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        val image = view.imagemAlbum
        private val titulo = view.tituloAlbum

        fun bindView(album: Album) {
            titulo.text = album.title

            itemView.setOnClickListener {
                onItemSelectedListener.invoke(album)
            }
        }
    }
}

