package com.bitperdido.pokedex.domain.pokedex.service.get

import com.bitperdido.pokedex.domain.Pokemon

interface PokemonsGetter {
    fun get(number: String) : Pokemon?
}