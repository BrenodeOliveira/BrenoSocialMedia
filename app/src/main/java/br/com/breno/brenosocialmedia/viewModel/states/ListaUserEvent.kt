package br.com.breno.brenosocialmedia.viewModel.states

sealed class ListaUserEvent {
    data class ExibirToast(val exibe: String) : ListaUserEvent()
}