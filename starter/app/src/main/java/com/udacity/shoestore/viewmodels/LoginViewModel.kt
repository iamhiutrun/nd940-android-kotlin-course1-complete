package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email: MutableLiveData<String> = MutableLiveData()

    val password: MutableLiveData<String> = MutableLiveData()

    // Error
    private val _emailError: MutableLiveData<String> = MutableLiveData()
    val emailError: LiveData<String>
        get() = _emailError

    private val _passwordError: MutableLiveData<String> = MutableLiveData()
    val passwordError: LiveData<String>
        get() = _passwordError

    private val _navigateToOnboard: MutableLiveData<Boolean> = MutableLiveData()
    val navigateToOnboard: LiveData<Boolean?>
        get() = _navigateToOnboard

    fun login() {
//        val email = email.value
//        val password = password.value
//        if (email?.isEmpty() == true) {
//            _emailError.postValue("Please input your email")
//            return
//        }
//
//        if (password?.isEmpty() == true) {
//            _passwordError.postValue("Please input your password")
//            return
//        }
//
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            _emailError.postValue("Email invalid")
//            return
//        }
//
//        if ((password?.length!! < 6)) {
//            _passwordError.postValue("Password must be greater than 6 characters")
//            return
//        } else {
            _navigateToOnboard.value = true
//        }
    }

    fun navigateToOnboardDone(){
        _navigateToOnboard.value = null
    }
}