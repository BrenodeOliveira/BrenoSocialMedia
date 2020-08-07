package br.com.breno.brenosocialmedia.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserEvent
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserInteractor
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserStates
import kotlinx.coroutines.launch
import java.lang.Exception

class ListaUserViewModel: ViewModel() {

    private val state : MutableLiveData<ListaUserStates> = MutableLiveData()
    val viewState: LiveData<ListaUserStates> = state

    private val event: MutableLiveData<ListaUserEvent> = MutableLiveData()
    val viewEvent: MutableLiveData<ListaUserEvent> = event

    private var firstTime = true

    fun init() {
        if (firstTime) {
            viewModelScope.launch {
                try {
                    state.value = ListaUserStates
                        .ListaUserSucesso("Juca")
                    firstTime = false
                } catch (exception : Exception) {
                    state.value = ListaUserStates.ListaUserError(exception)
                }
            }
        }
    }

    fun interpretar(acao: ListaUserInteractor) {
        when(acao) {
            is ListaUserInteractor.ExibeBotao -> this.init()
        }
    }

    fun resetEvent() {
        event.value = null
    }
}