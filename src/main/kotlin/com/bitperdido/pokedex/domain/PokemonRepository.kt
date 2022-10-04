package com.bitperdido.pokedex.domain

interface PokemonRepository {

    fun get(number : String) : Pokemon?

    fun matching(name : String?, favorite: Boolean?, type: List<String>?) : List<Pokemon>?

    fun modify(pokemon : Pokemon);
}