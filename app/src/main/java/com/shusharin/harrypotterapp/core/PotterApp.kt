package com.shusharin.harrypotterapp.core

import android.app.Application

class PotterApp: Application() {
    private companion object {
        const val BASE_URL = "http://hp-api.herokuapp.com/api/"
    }

}