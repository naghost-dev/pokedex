package com.heytrade.pokedex.domain.pokedex.service.find

import com.heytrade.pokedex.domain.Pokemon

interface PokemonsFinder {
    fun find(name: String?, favorite:Boolean?, type:List<String>?) : List<Pokemon>?
}