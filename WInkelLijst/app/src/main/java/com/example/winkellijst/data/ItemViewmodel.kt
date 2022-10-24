package com.example.winkellijst.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewmodel(application: Application) : AndroidViewModel(application) {

    val readAllItems: LiveData<List<Boodschap>>
    private val repository: ItemRepository

    init {
        val itemDao = ItemDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        readAllItems = repository.readAllItemsList

    }

    fun addItem(boodschap: Boodschap) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(boodschap)
        }
    }
    fun deleteBoodschap(boodschap: Boodschap){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteBoodschap(boodschap)
        }
    }
}