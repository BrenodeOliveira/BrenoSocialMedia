package br.com.breno.brenosocialmedia.model

import okhttp3.Address
import java.io.Serializable

data class Users(
    val id : Long,
    val name : String,
    val email : String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
) : Serializable