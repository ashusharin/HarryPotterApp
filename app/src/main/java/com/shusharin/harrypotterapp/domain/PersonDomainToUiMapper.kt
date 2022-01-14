package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.ui.PersonUi

interface PersonDomainToUiMapper : Abstract.Mapper {

    fun map(name:String, image:String) : PersonUi
}