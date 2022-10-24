package com.example.winkellijst.data

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {

    val readAllItemsList: LiveData<List<Boodschap>> = itemDao.readAllItems()
    suspend fun addItem(boodschap: Boodschap) {
        itemDao.addItem(boodschap)
    }

    suspend fun deleteBoodschap(boodschap: Boodschap) {
        itemDao.deleteBoodschap(boodschap)

    }

}