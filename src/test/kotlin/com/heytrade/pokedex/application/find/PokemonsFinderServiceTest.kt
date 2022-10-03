package com.heytrade.pokedex.application.find

import com.heytrade.pokedex.application.ApplicationTestCase
import com.heytrade.pokedex.domain.Pokemon
import com.heytrade.pokedex.domain.PokemonRepository
import com.heytrade.pokedex.domain.pokedex.service.find.PokemonsFinder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean

internal class PokemonsFinderServiceTest : ApplicationTestCase(){
    @Autowired
    var pokemonsFinder : PokemonsFinder? = null

    @Test
    @Throws(Exception::class)
    fun find_an_existing_pokemon() {
        Mockito.`when`(pokemonRepository?.matching("cyn",null,null)).thenReturn(listOf(getCompletePokemon()))

        val pokemon: List<Pokemon>?=pokemonsFinder?.find("cyn",null,null)

        assertNotNull(pokemon)

    }
}