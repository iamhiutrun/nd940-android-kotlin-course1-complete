package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnboardingBinding


class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentOnboardingBinding>(layoutInflater,
            R.layout.fragment_onboarding,container,false)

        binding.instructionsNextButton.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionOnboardingFragmentToShoeListingFragment())
        }

        return binding.root
    }

}