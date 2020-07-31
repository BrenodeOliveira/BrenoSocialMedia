package br.com.breno.brenosocialmedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.data.model.Users
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(private val itens: ArrayList<String>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolderUsers>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsers {
        return ViewHolderUsers(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int = itens.count()

    override fun onBindViewHolder(viewHolder: ViewHolderUsers, position: Int) {
        viewHolder.bindView(itens[position])
    }

    class ViewHolderUsers(view: View) : RecyclerView.ViewHolder(view) {
        private val nome = view.nomeUser

        fun bindView(users: String) {
            nome.text = users
        }
    }
}