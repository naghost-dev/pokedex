package com.heytrade.pokedex.application.modify

import com.heytrade.pokedex.application.ApplicationTestCase
import com.heytrade.pokedex.domain.Pokemon
import com.heytrade.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist
import com.heytrade.pokedex.domain.pokedex.service.modify.PokemonsModifier
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired

internal class PokemonModifierServiceTest : ApplicationTestCase(){

    @Autowired
    var pokemonsModifier : PokemonsModifier? = null
    @Test
    fun modify_an_existing_pokemon() {
        var pokemon: Pokemon =getCompletePokemon()
        pokemon.favorite=true

        Mockito.`when`(pokemonRepository?.get("157")).thenReturn(getCompletePokemon())

        pokemonsModifier?.modify("157",true)

        Mockito.verify(pokemonRepository)?.modify(pokemon)

    }

    @Test
    fun modify_an_not_existing_pokemon() {
        Mockito.`when`(pokemonRepository?.get("157")).thenReturn(null)
        assertThrows(PokemonUpdatedNotExist::class.java) { pokemonsModifier?.modify("157",false) };
    }
}