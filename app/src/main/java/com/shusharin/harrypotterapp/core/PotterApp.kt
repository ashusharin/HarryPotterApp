package com.shusharin.harrypotterapp.core

import android.app.Application
import com.shusharin.harrypotterapp.data.PersonRepository
import com.shusharin.harrypotterapp.data.ToPersonMapper
import com.shusharin.harrypotterapp.data.cache.ListPersonCacheDataSourse
import com.shusharin.harrypotterapp.data.cache.ListPersonCacheMapper
import com.shusharin.harrypotterapp.data.cache.PersonDataToDbMapper
import com.shusharin.harrypotterapp.data.cache.RealmProvider
import com.shusharin.harrypotterapp.data.net.ListPersonCloudDataSource
import com.shusharin.harrypotterapp.data.net.ListPersonCloudMapper
import com.shusharin.harrypotterapp.data.net.PersonsService
import com.shusharin.harrypotterapp.domain.BaseListPersonDataToDomainMapper
import com.shusharin.harrypotterapp.domain.BasePersonDataToDomainMapper
import com.shusharin.harrypotterapp.domain.ListPersonInteractor
import com.shusharin.harrypotterapp.ui.*
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class PotterApp : Application() {
    private companion object {
        const val BASE_URL = "http://hp-api.herokuapp.com/api/"
    }

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        val service = retrofit.create(PersonsService::class.java)
        val cloudDataSource = ListPersonCloudDataSource.Base(service)
        val cacheDataSource =
            ListPersonCacheDataSourse.Base(RealmProvider.Base(), PersonDataToDbMapper.Base())
        val toPersonMapper = ToPersonMapper.Base()
        val booksCloudMapper = ListPersonCloudMapper.Base(toPersonMapper)
        val booksCacheMapper = ListPersonCacheMapper.Base(toPersonMapper)
        val personRepository = PersonRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val personsInteractor = ListPersonInteractor.Base(
            personRepository,
            BaseListPersonDataToDomainMapper(BasePersonDataToDomainMapper())
        )
        val communication = PersonListCommunication.Base()
        mainViewModel = MainViewModel(
            personsInteractor,
            BaseListPersonDomainToUiMapper(ResourceProvider.Base(this),
                BasePersonDomainToUiMapper()),
            communication
        )
    }
}