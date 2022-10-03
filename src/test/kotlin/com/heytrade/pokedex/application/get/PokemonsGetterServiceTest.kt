package com.heytrade.pokedex.application.get

import com.heytrade.pokedex.application.ApplicationTestCase
import com.heytrade.pokedex.domain.Pokemon
import com.heytrade.pokedex.domain.pokedex.error.get.PokemonNotExist
import com.heytrade.pokedex.domain.pokedex.service.find.PokemonsFinder
import com.heytrade.pokedex.domain.pokedex.service.get.PokemonsGetter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired

internal class PokemonsGetterServiceTest : ApplicationTestCase(){
    @Autowired
    var pokemonsGetter : PokemonsGetter? = null

    @Test
    fun get_an_existing_pokemon() {
        Mockito.`when`(pokemonRepository?.get("157")).thenReturn(getCompletePokemon())

        val pokemon: Pokemon?=pokemonsGetter?.get("157")

        assertNotNull(pokemon)

    }

    @Test
    fun get_an_not_existing_pokemon() {
        Mockito.`when`(pokemonRepository?.get("157")).thenReturn(null)
        assertThrows(PokemonNotExist::class.java) { pokemonsGetter?.get("157") };
    }
}