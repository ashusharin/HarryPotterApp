package com.shusharin.harrypotterapp.data.cache

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.data.PersonData
import com.shusharin.harrypotterapp.data.ToPersonMapper
import io.realm.RealmObject

open class PersonDb : RealmObject(), Abstract.Object<PersonData, ToPersonMapper> {
    var name: String = ""
    var image: String = ""

    override fun map(mapper: ToPersonMapper) = PersonData(name, image)
}