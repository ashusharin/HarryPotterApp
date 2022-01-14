package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.data.cache.DbWrapper
import com.shusharin.harrypotterapp.data.cache.PersonDataToDbMapper
import com.shusharin.harrypotterapp.data.cache.PersonDb
import com.shusharin.harrypotterapp.domain.PersonDomain

data class PersonData(private val name: String, private val image: String) :
    ToPersonDb<PersonDb, PersonDataToDbMapper>,
    Abstract.Object<PersonDomain, PersonDataToDomainMapper> {
    override fun map(mapper: PersonDataToDomainMapper): PersonDomain = mapper.map(name, image)
    override fun mapTo(mapper: PersonDataToDbMapper, db: DbWrapper) =
        mapper.mapToDb(name, image, db)
}

//todo make it better later
interface ToPersonDb<T, M : Abstract.Mapper> {

    fun mapTo(mapper: M, db: DbWrapper): T
}
