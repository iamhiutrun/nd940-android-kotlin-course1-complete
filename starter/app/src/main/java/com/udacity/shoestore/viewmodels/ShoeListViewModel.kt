package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
    private val _shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    val shoe : MutableLiveData<Shoe> = MutableLiveData(Shoe())

    private val _popToShoeList : MutableLiveData<Boolean?> = MutableLiveData()
    val popToShoeList : LiveData<Boolean?>
        get() = _popToShoeList

    init {
        _shoes.postValue(mutableListOf())
    }

    fun addShoe(){
        shoe.value?.let {
            _shoes.value?.add(it.copy())
            _popToShoeList.value = true
        }
    }

    fun cancel(){
        _popToShoeList.value = true
    }

    fun popDone(){
        _popToShoeList.value = null
    }

}