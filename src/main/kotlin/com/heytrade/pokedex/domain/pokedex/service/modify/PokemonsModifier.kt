package com.heytrade.pokedex.domain.pokedex.service.modify

import com.heytrade.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist

interface PokemonsModifier  {
    @Throws(PokemonUpdatedNotExist::class)
    fun modify(number: String, favorite:Boolean)
}