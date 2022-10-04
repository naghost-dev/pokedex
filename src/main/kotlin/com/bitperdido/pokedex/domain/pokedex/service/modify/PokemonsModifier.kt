package com.bitperdido.pokedex.domain.pokedex.service.modify

import com.bitperdido.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist

interface PokemonsModifier  {
    @Throws(PokemonUpdatedNotExist::class)
    fun modify(number: String, favorite:Boolean)
}