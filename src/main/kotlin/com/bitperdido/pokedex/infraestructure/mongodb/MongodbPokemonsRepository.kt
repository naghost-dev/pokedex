package com.bitperdido.pokedex.infraestructure.persistence.mongodb

import com.bitperdido.pokedex.domain.Pokemon
import com.bitperdido.pokedex.domain.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.MongoRegexCreator
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository


@Repository
class MongodbPokemonsRepository (@Autowired val springDataMongodbPokemonRepository: SpringDataMongodbPokemonsRepository, @Autowired val mongoTemplate: MongoTemplate) : PokemonRepository{

    override fun get(number: String): Pokemon? {
        return springDataMongodbPokemonRepository.findByNumber(number)?.toDomain()
    }

    override fun matching(name: String?, favorite: Boolean?, type:List<String>?): List<Pokemon>? {
        val dynamicQuery = Query()
        if (name != null) {
            val regex = MongoRegexCreator.INSTANCE
                .toRegularExpression(name, MongoRegexCreator.MatchMode.LIKE)
            val nameCriteria: Criteria = Criteria.where("name").`regex`(regex!!)
            dynamicQuery.addCriteria(nameCriteria)
        }
        if (favorite != null) {
            val favoriteCriteria: Criteria = Criteria.where("favorite").`is`(favorite)
            dynamicQuery.addCriteria(favoriteCriteria)
        }
        if (type != null) {
            val typeCriteria: Criteria = Criteria.where("type").`is`(type)
            dynamicQuery.addCriteria(typeCriteria)
        }
        var mongoResult: List<MongodbPokemon>? = mongoTemplate.find(dynamicQuery, MongodbPokemon::class.java)

        return mongoResult?.map(MongodbPokemon::toDomain)
    }

   override fun modify(pokemon: Pokemon) {

       springDataMongodbPokemonRepository.save(MongodbPokemon(pokemon))
    }



}


