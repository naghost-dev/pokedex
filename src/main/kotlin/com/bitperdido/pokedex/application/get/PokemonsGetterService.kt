package com.bitperdido.pokedex.application.get

import com.bitperdido.pokedex.domain.Pokemon
import com.bitperdido.pokedex.domain.PokemonRepository
import com.bitperdido.pokedex.domain.pokedex.error.get.PokemonNotExist
import com.bitperdido.pokedex.domain.pokedex.service.get.PokemonsGetter

class PokemonsGetterService (private val pokemonRepository: PokemonRepository) : PokemonsGetter{

    override fun get(number: String) : Pokemon? {
        val pokemon: Pokemon?=pokemonRepository.get(number)
        if(pokemon!=null){
            return pokemon
        }
       throw PokemonNotExist("Pokemon #$number not exist")
    }
}