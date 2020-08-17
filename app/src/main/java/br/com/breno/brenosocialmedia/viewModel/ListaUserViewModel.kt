package br.com.breno.brenosocialmedia.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserEvent
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserInteractor
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserStates

class ListaUserViewModel : ViewModel() {

    private val state: MutableLiveData<ListaUserStates> = MutableLiveData()
    val viewState: LiveData<ListaUserStates> = state

    private val event: MutableLiveData<ListaUserEvent> = MutableLiveData()
    val viewEvent: MutableLiveData<ListaUserEvent> = event

    var firstTime = true

    fun init() {
        if (firstTime) {
            try {
                state.value = ListaUserStates
                    //Fazer uma lista aleatoria para retornar
                    .ListaUserSucesso("Juca")
                event.value = ListaUserEvent.ExibirToast("event happen first time true")
                firstTime = false
            } catch (exception: Exception) {
                state.value = ListaUserStates.ListaUserError(exception)
            }
        } else {
            try {
                state.value = ListaUserStates
                    .ListaUserSucesso("Brenin")
                event.value = ListaUserEvent.ExibirToast("event happen first time false")
                firstTime = true
            } catch (exception: Exception) {
                state.value = ListaUserStates.ListaUserError(exception)
            }
        }
    }

    fun interpretar(acao: ListaUserInteractor) {
        when (acao) {
            is ListaUserInteractor.ExibeBotao -> this.init()
        }
    }

    fun resetEvent() {
        event.value = null
    }
}