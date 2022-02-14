package com.example.voer.DataBase

import androidx.lifecycle.LiveData

class SettingsRepository(private val settingsDao: SettingsDao) {

        var theSettings : LiveData<Settings> = settingsDao.readSettings()

        suspend fun addSettings(settings: Settings){
            settingsDao.addSettings(settings)
        }
        suspend fun updateSettings(settings: Settings){
            settingsDao.updateSettings(settings)



    }



}