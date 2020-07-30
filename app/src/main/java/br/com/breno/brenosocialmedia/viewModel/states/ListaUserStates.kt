package br.com.breno.brenosocialmedia.viewModel.states

import br.com.breno.brenosocialmedia.data.model.Photos
import java.lang.Exception

sealed class ListaUserStates {
    data class ListaUserSucesso(val lista: ArrayList<Photos>) : ListaUserStates()
    data class ListaUserError(val error: Exception) : ListaUserStates()
}