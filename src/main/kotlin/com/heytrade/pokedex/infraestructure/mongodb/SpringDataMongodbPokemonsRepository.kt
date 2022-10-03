package com.heytrade.pokedex.infraestructure.persistence.mongodb

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringDataMongodbPokemonsRepository : MongoRepository<MongodbPokemon, String> {
    fun findByNumber(number:String) : MongodbPokemon?
}