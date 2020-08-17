package br.com.breno.brenosocialmedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.breno.brenosocialmedia.viewModel.ListaUserViewModel
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserEvent
import br.com.breno.brenosocialmedia.viewModel.states.ListaUserStates
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListaUserViewModelTest {

    @MockK
    var exception = java.lang.NullPointerException()
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)

    }

    @Test
    fun `quando iniciar a viewmodel deve retornar o nome e toast`() {
        val viewmodel = ListaUserViewModel()
        runBlocking {
            viewmodel.init()
            Assert.assertEquals(ListaUserStates.ListaUserSucesso("Juca"), viewmodel.viewState.value)
            Assert.assertEquals(ListaUserEvent.ExibirToast("event happen first time true"), viewmodel.viewEvent.value)
        }
    }

    @Test
    fun `quando o first time for false`() {
        val viewmodel = ListaUserViewModel()
        viewmodel.firstTime = false
        runBlocking {
            viewmodel.init()
            Assert.assertEquals(ListaUserStates.ListaUserSucesso("Brenin"), viewmodel.viewState.value)
            Assert.assertEquals(ListaUserEvent.ExibirToast("event happen first time false"), viewmodel.viewEvent.value)
        }
    }

    @Test
    fun `quando iniciar o viewmodel passa na exception`() {
        val viewmodel = ListaUserViewModel()
        runBlocking {
            viewmodel.init()
            Assert.assertNotEquals(ListaUserStates.ListaUserError(exception), viewmodel.viewState.value)
        }
    }

    @Test
    fun `quando o first time for false e ocorrer exception`() {
        val viewmodel = ListaUserViewModel()
        viewmodel.firstTime = false
        runBlocking {
            viewmodel.init()
            Assert.assertNotEquals(ListaUserStates.ListaUserError(exception), viewmodel.viewState.value)
        }
    }

}