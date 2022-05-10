package com.udacity.shoestore.custom_view

import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil


class ShoeItem: LinearLayout {
    constructor(context: Context) : super(context)

    private val binding: ShoeItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_item, this, false)

    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoeName.text = shoe.name
            companyName.text = shoe.company
            tvSize.text = shoe.size.toString()
            description.text = shoe.description
        }
    }
}