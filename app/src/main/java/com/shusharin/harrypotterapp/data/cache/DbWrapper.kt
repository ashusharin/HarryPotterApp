package com.shusharin.harrypotterapp.data.cache

import io.realm.Realm

interface DbWrapper {
    fun createObject(): PersonDb

    class Base(private val realm: Realm) : DbWrapper{
        override fun createObject(): PersonDb {
            return realm.createObject(PersonDb::class.java)
        }
    }
}