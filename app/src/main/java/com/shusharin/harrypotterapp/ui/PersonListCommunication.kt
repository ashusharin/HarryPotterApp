package com.shusharin.harrypotterapp.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.shusharin.harrypotterapp.core.Abstract

interface PersonListCommunication : Abstract.Mapper {
    fun map(listPerson: List<PersonUi>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<PersonUi>>)

    class Base : PersonListCommunication {
        private val listLiveData = MutableLiveData<List<PersonUi>>()
        override fun observe(owner: LifecycleOwner, observer: Observer<List<PersonUi>>) {
            listLiveData.observe(owner, observer)
        }

        override fun map(listPerson: List<PersonUi>) {
            listLiveData.value = listPerson
        }
    }
}