package br.com.breno.brenosocialmedia.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.adapter.UsersAdapter
import br.com.breno.brenosocialmedia.viewModel.ListaUserViewModel
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserStates
import kotlinx.android.synthetic.main.activity_lista_user.*
import java.lang.Exception
import java.util.ArrayList

class ListaUserActivity : AppCompatActivity() {

    private lateinit var viewModel: ListaUserViewModel
    var adapter : UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_user)

        viewModel = ViewModelProvider(this).get(ListaUserViewModel::class.java)

        observers()
    }

    fun observers() {
        viewModel.viewState.observe(this, Observer { state ->
            state.let {
                when(it) {
                    is ListaUserStates.ListaUserSucesso -> preencheRv(it.lista)
                    is ListaUserStates.ListaUserError -> exibeErro()
                }
            }
        })
    }

    private fun exibeErro() {
        recyclerUsers.visibility = View.GONE
        btnTenteNovamente.visibility = View.VISIBLE
    }

    private fun preencheRv(lista: ArrayList<String>) {
        recyclerUsers.visibility = View.VISIBLE
        btnTenteNovamente.visibility = View.GONE
        adapter?.notifyDataSetChanged() ?: preencheRv(lista)
    }
}
