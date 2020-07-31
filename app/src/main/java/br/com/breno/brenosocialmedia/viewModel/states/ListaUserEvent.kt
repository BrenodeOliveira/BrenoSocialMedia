package br.com.breno.brenosocialmedia.viewModel.states

sealed class ListaUserEvent {
    data class exibirNomes(val exibe: String) : ListaUserEvent()
}