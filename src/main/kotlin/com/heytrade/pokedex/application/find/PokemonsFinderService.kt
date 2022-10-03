package com.heytrade.pokedex.application.find

import com.heytrade.pokedex.domain.Pokemon
import com.heytrade.pokedex.domain.PokemonRepository
import com.heytrade.pokedex.domain.pokedex.service.find.PokemonsFinder

class PokemonsFinderService (private val pokemonRepository: PokemonRepository) : PokemonsFinder {

    override fun find(number: String?, favorite:Boolean?, type:List<String>?) : List<Pokemon>? {
        return pokemonRepository.matching(number, favorite, type)
    }
}