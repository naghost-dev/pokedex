package com.heytrade.pokedex.application.get

import com.heytrade.pokedex.domain.Pokemon
import com.heytrade.pokedex.domain.PokemonRepository
import com.heytrade.pokedex.domain.pokedex.error.get.PokemonNotExist
import com.heytrade.pokedex.domain.pokedex.service.get.PokemonsGetter

class PokemonsGetterService (private val pokemonRepository: PokemonRepository) : PokemonsGetter{

    override fun get(number: String) : Pokemon? {
        val pokemon: Pokemon?=pokemonRepository.get(number)
        if(pokemon!=null){
            return pokemon
        }
       throw PokemonNotExist("Pokemon #$number not exist")
    }
}