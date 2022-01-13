package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.core.Abstract

interface ListPersonMapper : Abstract.Mapper {

    fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData>

    class Base(private val personMapper: ToPersonMapper) : ListPersonMapper {
        override fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData> =
            cloudList.map { personCloud ->
                personCloud.map(personMapper)
            }
    }
}