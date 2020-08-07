package br.com.breno.brenosocialmedia.presentation.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.viewModel.ListaUserViewModel
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserEvent
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserStates
import kotlinx.android.synthetic.main.activity_lista_user.*

class ListaUserActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var viewModel: ListaUserViewModel
//    var adapter : UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_user)

        viewModel = ViewModelProvider(this).get(ListaUserViewModel::class.java)

        initBtn()

        observersState()
        observerEvent()
        setListeners()
    }

    private fun initBtn() {
        btnTenteNovamente.visibility = View.GONE
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnTenteNovamente -> Toast.makeText(this, "Tente novamente", Toast.LENGTH_SHORT).show()
            R.id.btnToastNome -> Toast.makeText(this, "Nome user", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setListeners() {
        btnTenteNovamente.setOnClickListener(this)
        btnToastNome.setOnClickListener(this)
    }

    private fun observersState() {
        viewModel.viewState.observe(this, Observer { state ->
            state?.let {
                when(it) {
                    is ListaUserStates.ListaUserSucesso -> preencheNome(it.nomeUser)
                    is ListaUserStates.ListaUserError -> exibeErro()
                }
            }
        })
        viewModel.init()
    }

    private fun observerEvent() {
        viewModel.viewEvent.observe(this, Observer { event ->
            event?.let {
                when(it) {
                    is ListaUserEvent.ExibirToast -> getNome()
                }
            }
        })
    }

    private fun exibeErro() {
        txt_name.visibility = View.GONE
        btnTenteNovamente.visibility = View.VISIBLE
        btnToastNome.visibility = View.GONE
    }

    private fun preencheNome(name: String) {
        txt_name.visibility = View.VISIBLE
        btnTenteNovamente.visibility = View.GONE
        txt_name.text = name
    }

    private fun getNome() : String {
        return "Brenito"
    }
}
