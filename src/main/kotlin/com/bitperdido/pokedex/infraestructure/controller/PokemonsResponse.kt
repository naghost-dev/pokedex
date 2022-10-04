package com.bitperdido.pokedex.infraestructure.rest.controller

import com.bitperdido.pokedex.domain.Pokemon

data class PokemonsResponse(
    var  number:String?,
    var name : String?,
    var type: List<String>?,
    var favorite:Boolean?,
    var imgUrl:String?,
    var soundUrl:String?,
    var evolutions:List<PokemonsResponse>?,
    var cp:Int?,
    var hp:Int?,
    var minWeight:Double?,
    var maxWeight:Double?,
    var minHeight:Double?,
    var maxHeight:Double?) {
    constructor(pokemon: Pokemon) : this(pokemon.number,pokemon.name,pokemon.type,pokemon.favorite,pokemon.imgUrl,pokemon.soundUrl,pokemon.evolutions?.map {q-> PokemonsResponse(q) },pokemon.cp,pokemon.hp,pokemon.minWeight,pokemon.maxWeight,pokemon.minHeight,pokemon.maxHeight)
}
