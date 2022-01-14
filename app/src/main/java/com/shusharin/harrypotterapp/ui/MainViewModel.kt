package com.shusharin.harrypotterapp.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shusharin.harrypotterapp.domain.ListPersonDomainToUiMapper
import com.shusharin.harrypotterapp.domain.ListPersonInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val personsInteractor: ListPersonInteractor,
    private val mapper: ListPersonDomainToUiMapper,
    private val communication: PersonListCommunication
) : ViewModel() {//todo interface

    fun fetchPerson() {
        communication.map(listOf(PersonUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = personsInteractor.fetchListPerson()
            val resultUi = resultDomain.map(mapper)
            withContext(Dispatchers.Main) {
               resultUi.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<PersonUi>>) {
        communication.observe(owner, observer)
    }




}