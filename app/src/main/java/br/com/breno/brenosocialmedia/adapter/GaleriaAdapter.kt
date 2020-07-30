package br.com.breno.brenosocialmedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.data.model.Album
import br.com.breno.brenosocialmedia.data.model.Photos
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_galeria.view.*

class GaleriaAdapter(
    val fotos: List<Photos>,
    private val onItemSelectedListener: ((photos: Photos) -> Unit)
) : RecyclerView.Adapter<GaleriaAdapter.ViewHolderGaleria>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGaleria {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_galeria, parent, false)

        return ViewHolderGaleria(itemView, onItemSelectedListener)
    }

    override fun getItemCount(): Int = fotos.count()

    override fun onBindViewHolder(viewHolder: ViewHolderGaleria, position: Int) {
        val foto = fotos.get(position)

        viewHolder.bindView(fotos[position])

        Picasso.get()
            .load(foto.thumbnailUrl)
            .into(viewHolder.imagemItem)
    }

    class ViewHolderGaleria(view: View,
        private val onItemSelectedListener: ((photos: Photos) -> Unit)) :
        RecyclerView.ViewHolder(view) {
        val imagemItem = view.imagemGaleria

        fun bindView(photos: Photos) {
            itemView.setOnClickListener {
                onItemSelectedListener.invoke(photos)
            }
        }
    }
}