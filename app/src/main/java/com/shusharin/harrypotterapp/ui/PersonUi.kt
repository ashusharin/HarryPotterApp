package com.shusharin.harrypotterapp.ui

import com.shusharin.harrypotterapp.core.Abstract

sealed class PersonUi : Abstract.Object<Unit, PersonUi.StringMapper> {
    override fun map(mapper: StringMapper) = Unit

    object Progress : PersonUi()

    class Base(
        private val name: String,
        private val image: String,
    ) : PersonUi() {
        override fun map(mapper: StringMapper) = mapper.map(name)
    }

    class Fail(
        private val message: String,
    ) : PersonUi() {
        override fun map(mapper: StringMapper) = mapper.map(message)
    }

    interface StringMapper : Abstract.Mapper {
        fun map(text: String)
    }
}