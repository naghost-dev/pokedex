package com.heytrade.pokedex.infraestructure.persistence.mongodb

import com.heytrade.pokedex.domain.Pokemon
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pokemon")
data class MongodbPokemon(
    @Id var _id: String?,
    var number:String?,
    var name: String?,
    var type: List<String>?,
    var favorite:Boolean?,
    var imgUrl:String?,
    var soundUrl:String?,
    var evolutions:List<MongodbPokemon>?,
    var cp:Int?,
    var hp:Int?,
    var minWeight:Double?,
    var maxWeight:Double?,
    var minHeight:Double?,
    var maxHeight:Double?) {
    constructor(pokemon: Pokemon) : this(pokemon.id,pokemon.number,pokemon.name,pokemon.type,pokemon.favorite,pokemon.imgUrl,pokemon.soundUrl,pokemon.evolutions?.map {q-> MongodbPokemon(q)},pokemon.cp,pokemon.hp,pokemon.minWeight,pokemon.maxWeight,pokemon.minHeight,pokemon.maxHeight)

    fun toDomain(): Pokemon {
        return Pokemon(_id,number,name,type,favorite,imgUrl,soundUrl,evolutions?.map(MongodbPokemon::toDomain),cp,hp,minWeight,maxWeight,minHeight,maxHeight)
    }


}