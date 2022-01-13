package com.shusharin.harrypotterapp.data.net

import okhttp3.ResponseBody
import retrofit2.http.GET

interface PersonsService {

    @GET("characters ")
    suspend fun fetchBooks(): List<PersonCloud>
}