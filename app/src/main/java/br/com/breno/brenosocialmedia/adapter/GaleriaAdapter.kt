package br.com.breno.brenosocialmedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.data.model.Photos
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_galeria.view.*

class GaleriaAdapter(val fotos: List<Photos>) : RecyclerView.Adapter<GaleriaAdapter.ViewHolderGaleria>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGaleria {
        return ViewHolderGaleria(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_galeria, parent, false)
        )
    }

    override fun getItemCount(): Int = fotos.count()

    override fun onBindViewHolder(holder: ViewHolderGaleria, position: Int) {
        val foto = fotos.get(position)

        Picasso.get()
            .load(foto.thumbnailUrl)
            .into(holder.imagemItem)
    }

    class ViewHolderGaleria(view: View) : RecyclerView.ViewHolder(view) {
        val imagemItem = view.imagemGaleria
    }
}