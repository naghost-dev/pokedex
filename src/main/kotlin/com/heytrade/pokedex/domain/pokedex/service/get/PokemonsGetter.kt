package com.heytrade.pokedex.domain.pokedex.service.get

import com.heytrade.pokedex.domain.Pokemon

interface PokemonsGetter {
    fun get(number: String) : Pokemon?
}