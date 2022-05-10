package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodels.ShoeListViewModel


class ShoeDetailFragment : Fragment() {

    private val shoeListViewModel : ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentShoeDetailBinding.inflate(inflater, container,false)

        with(binding){
            shoeListingViewModel = shoeListViewModel
            lifecycleOwner = this@ShoeDetailFragment
        }

        shoeListViewModel.popToShoeList.observe(viewLifecycleOwner) {
            if (it==true) {
                findNavController().popBackStack()
                shoeListViewModel.popDone()
            }
        }


        return binding.root
    }

}