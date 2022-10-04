package com.bitperdido.pokedex.application.find

import com.bitperdido.pokedex.domain.Pokemon
import com.bitperdido.pokedex.domain.PokemonRepository
import com.bitperdido.pokedex.domain.pokedex.service.find.PokemonsFinder

class PokemonsFinderService (private val pokemonRepository: PokemonRepository) : PokemonsFinder {

    override fun find(number: String?, favorite:Boolean?, type:List<String>?) : List<Pokemon>? {
        return pokemonRepository.matching(number, favorite, type)
    }
}