package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.data.cache.ListPersonCacheDataSourse
import com.shusharin.harrypotterapp.data.cache.ListPersonCacheMapper
import com.shusharin.harrypotterapp.data.net.ListPersonCloudDataSource
import com.shusharin.harrypotterapp.data.net.ListPersonCloudMapper
import java.lang.Exception

interface PersonRepository {

    suspend fun fetchListPerson(): ListPersonData

    class Base(
        private val cloudDataSource: ListPersonCloudDataSource,
        private val cacheDataSourse: ListPersonCacheDataSourse,
        private val listPersonCloudMapper: ListPersonCloudMapper,
        private val listPersonCacheMapper: ListPersonCacheMapper,
    ) : PersonRepository {
        override suspend fun fetchListPerson(): ListPersonData = try {
            val listPersonCache = cacheDataSourse.fetchListPerson()
            if (listPersonCache.isEmpty()) {
                val listPersonCloud = cloudDataSource.fetchListPerson()
                val personList = listPersonCloudMapper.map(listPersonCloud)
                cacheDataSourse.saveListPerson(personList)
                ListPersonData.Success(personList)
            } else {
                ListPersonData.Success(listPersonCacheMapper.map(listPersonCache))
            }
        } catch (e:Exception){
            ListPersonData.Fail(e)
        }
    }
}