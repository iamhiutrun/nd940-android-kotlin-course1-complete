package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.custom_view.ShoeItem
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.viewmodels.ShoeListViewModel
import timber.log.Timber


class ShoeListingFragment : Fragment() {
    val shoeListViewModel : ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShoeListingBinding>(layoutInflater,
            R.layout.fragment_shoe_listing,container,false)

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        shoeListViewModel.shoes.observe(viewLifecycleOwner){
            context?.let { context ->
                val shoeContainer = binding.lnListShoe
                it.forEach { shoe ->
                    Timber.d(shoe.toString())
                    val shoeLayout = ShoeItem(context)
                    shoeLayout.loadShoe(shoe)
                    shoeContainer.addView(shoeLayout)
                }
            }
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}