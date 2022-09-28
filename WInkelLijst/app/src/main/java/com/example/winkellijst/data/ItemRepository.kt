package com.example.winkellijst.data

import androidx.lifecycle.LiveData

class ItemRepository (private val itemDao : ItemDao){

   val readAllItemsList : LiveData<List<Item>> = itemDao.readAllItems()
  suspend  fun addItem(item:Item){
      itemDao.addItem(item)
  }





}