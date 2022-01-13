package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.core.Abstract
// For cloud for one person TODO: 13.01.2022 remove
interface ToPersonMapper : Abstract.Mapper {

    fun map(name: String, image: String): PersonData

    class Base() : ToPersonMapper{
        override fun map(name: String, image: String) = PersonData(name,image)
    }
}