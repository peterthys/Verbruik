package com.example.winkellijst.data

import androidx.lifecycle.LiveData

class BoodschapRepository(private val boodschapDao: BoodschapDao) {

    val readAllItemsList: LiveData<List<Boodschap>> = boodschapDao.readAllItems()
    suspend fun addItem(boodschap: Boodschap) {
        boodschapDao.addItem(boodschap)
    }

    suspend fun deleteBoodschap(boodschap: Boodschap) {
        boodschapDao.deleteBoodschap(boodschap)
    }
    suspend fun deleteAllBoodschap() {
        boodschapDao.deleteAllBoodschap()
    }
    fun staatReedsInDeLijst(productsName: String):Boolean{
        val exists = boodschapDao.staatReedsInDeLijst(productsName)
        return exists

    }

}