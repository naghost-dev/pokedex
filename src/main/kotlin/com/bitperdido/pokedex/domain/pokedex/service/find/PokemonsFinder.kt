package com.bitperdido.pokedex.domain.pokedex.service.find

import com.bitperdido.pokedex.domain.Pokemon

interface PokemonsFinder {
    fun find(name: String?, favorite:Boolean?, type:List<String>?) : List<Pokemon>?
}