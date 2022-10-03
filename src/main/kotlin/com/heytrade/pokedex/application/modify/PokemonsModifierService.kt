package com.heytrade.pokedex.application.modify

import com.heytrade.pokedex.domain.PokemonRepository
import com.heytrade.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist
import com.heytrade.pokedex.domain.pokedex.service.modify.PokemonsModifier

class PokemonsModifierService (private val pokemonRepository: PokemonRepository) : PokemonsModifier {

    override fun modify(number: String, favorite:Boolean)  {
        var pokemon= pokemonRepository.get(number) ?: throw PokemonUpdatedNotExist("Pokemon #$number not exist")
        pokemon.favorite=favorite
        pokemonRepository.modify(pokemon)
    }
}