package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodels.LoginViewModel


class LoginFragment : Fragment() {
    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.apply {
            this.loginViewModel = this@LoginFragment.loginViewModel
            lifecycleOwner = this@LoginFragment
        }

        loginViewModel.navigateToOnboard.observe(viewLifecycleOwner) {
            if (it == true) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnboardingFragment())
                loginViewModel.navigateToOnboardDone()
            }
        }

        return binding.root
    }

}