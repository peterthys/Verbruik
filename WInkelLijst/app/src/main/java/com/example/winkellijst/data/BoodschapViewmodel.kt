package com.example.winkellijst.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BoodschapViewmodel(application: Application) : AndroidViewModel(application) {

    val readAllItems: LiveData<List<Boodschap>>
    private val repository: BoodschapRepository

    init {
        val itemDao = BoodschapDatabase.getDatabase(application).itemDao()
        repository = BoodschapRepository(itemDao)
        readAllItems = repository.readAllItemsList

    }

    fun addItem(boodschap: Boodschap) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(boodschap)
        }
    }

    fun deleteBoodschap(boodschap: Boodschap) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBoodschap(boodschap)
        }
    }

    fun deleteAllBoodschap() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllBoodschap()
        }
    }

    fun staatReedsInDeLijst(productsName: String): Boolean {
        var exists: Boolean = false

        viewModelScope.launch(Dispatchers.IO) {

            exists = repository.staatReedsInDeLijst(productsName)


        }
        return exists
    }
}