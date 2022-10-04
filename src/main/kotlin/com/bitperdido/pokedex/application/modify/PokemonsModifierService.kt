package com.bitperdido.pokedex.application.modify

import com.bitperdido.pokedex.domain.PokemonRepository
import com.bitperdido.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist
import com.bitperdido.pokedex.domain.pokedex.service.modify.PokemonsModifier

class PokemonsModifierService (private val pokemonRepository: PokemonRepository) : PokemonsModifier {

    override fun modify(number: String, favorite:Boolean)  {
        var pokemon= pokemonRepository.get(number) ?: throw PokemonUpdatedNotExist("Pokemon #$number not exist")
        pokemon.favorite=favorite
        pokemonRepository.modify(pokemon)
    }
}