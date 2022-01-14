package com.shusharin.harrypotterapp.data.net

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.data.PersonData
import com.shusharin.harrypotterapp.data.ToPersonMapper

interface ListPersonCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData>

    class Base(private val personMapper: ToPersonMapper) : ListPersonCloudMapper {
        override fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData> =
            cloudList.map { personCloud ->
                personCloud.map(personMapper)
            }
    }
}