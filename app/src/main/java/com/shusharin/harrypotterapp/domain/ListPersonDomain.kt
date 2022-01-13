package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.core.Abstract

sealed class ListPersonDomain: Abstract.Object<ListPersonUi, ListPersonDomainToUiMapper>  {

    class Success() : ListPersonDomain(){}

    class Fail(private val e: Exception) : ListPersonDomain()
}

