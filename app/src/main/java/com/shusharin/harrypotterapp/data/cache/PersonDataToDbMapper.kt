package com.shusharin.harrypotterapp.data.cache

import com.shusharin.harrypotterapp.core.Abstract

interface PersonDataToDbMapper : Abstract.Mapper {
    fun mapToDb(name: String, image: String, db: DbWrapper): PersonDb

    class Base : PersonDataToDbMapper {
        override fun mapToDb(name: String, image: String, db: DbWrapper): PersonDb {
            val personDb = db.createObject()
            personDb.name = name
            personDb.image = image
            return personDb
        }
    }
}