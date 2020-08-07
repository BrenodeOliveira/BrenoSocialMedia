package br.com.breno.brenosocialmedia.viewModel.states

sealed class ListaUserStates {
    data class ListaUserSucesso(val nomeUser: String) : ListaUserStates()
    data class ListaUserError(val error: Exception) : ListaUserStates()
}