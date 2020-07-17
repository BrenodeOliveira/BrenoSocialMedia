package br.com.breno.brenosocialmedia.activity

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.data.model.Users
import br.com.breno.brenosocialmedia.data.service.UsersService
import br.com.breno.brenosocialmedia.presentation.activities.LoginActivity
import br.com.breno.brenosocialmedia.viewModel.LoginViewModel
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Call

class LoginViewModelTest {

    companion object {
        val USERNAME_CORRETO: String = "Bret"
        val USERNAME_ERRADO: String = "Breno"
        val ERRO_USERNAME_INVALIDO: String = "User not found"
        val ERRO_CAMPO_VAZIO: String = "Null or Blank"
    }

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = LoginViewModel(Application())
    }

    @Test
    fun `when API result is success in viewModel`(){
        whenever(viewModel.postsLiveData).thenReturn(MutableLiveData(1))

        viewModel.checkUser("Bret")

        assertEquals(true, viewModel.checkUser("Bret"))

        verify(viewModel).postsLiveData.value
    }

    @Test
    fun testEquals() {
        assertEquals(4, 2+2)
    }
}