package com.shusharin.harrypotterapp.data.cache

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.data.PersonData
import com.shusharin.harrypotterapp.data.ToPersonMapper

interface ListPersonCacheMapper : Abstract.Mapper {

    fun map(persons: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData>

    class Base(private val mapper: ToPersonMapper) : ListPersonCacheMapper {
        override fun map(persons: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData> =
            persons.map { personDb ->
                personDb.map(mapper)
            }
    }
}