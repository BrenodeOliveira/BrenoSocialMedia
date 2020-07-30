package br.com.breno.brenosocialmedia.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.viewModel.ListaUserViewModel

class ListaUserActivity : AppCompatActivity() {

    private lateinit var viewModel: ListaUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_user)

        viewModel = ViewModelProvider(this).get(ListaUserViewModel::class.java)


    }
}
