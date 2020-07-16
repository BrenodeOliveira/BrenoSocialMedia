package br.com.breno.brenosocialmedia.activity

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.breno.brenosocialmedia.data.model.Users
import br.com.breno.brenosocialmedia.data.service.UsersService
import br.com.breno.brenosocialmedia.presentation.activities.LoginActivity
import br.com.breno.brenosocialmedia.viewModel.LoginViewModel
import org.junit.Rule
import org.junit.Test
import retrofit2.Call

class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginViewModel

    @Test
    fun `when API result is success in viewModel`(){
        viewModel = LoginViewModel()
    }
}