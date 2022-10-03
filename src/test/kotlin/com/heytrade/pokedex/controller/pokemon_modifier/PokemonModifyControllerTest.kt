package com.heytrade.pokedex.infraestructure.rest.controller.pokemon_modifier

import com.heytrade.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist
import com.heytrade.pokedex.domain.pokedex.service.modify.PokemonsModifier
import com.heytrade.pokedex.infraestructure.rest.controller.ApplicationRestTestCase
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean

internal class PokemonModifyControllerTest : ApplicationRestTestCase() {

    @Autowired
    @MockBean
    protected var pokemonsModifier: PokemonsModifier? = null


    @Test
    @Throws(Exception::class)
    fun update_an_existing_pokemon() {

        Mockito.doNothing().`when`(pokemonsModifier)?.modify("157", true)
        val number = "157"

        val body ="{ \"favorite\": true}"
        givenThereIsAPokemon(number, body,200)
        assertResponsePatch("/pokemons/$number", 200, body,"")
    }


    @Test
    @Throws(Exception::class)
    fun update_an_not_existing_pokemon() {
        val number = "152"
        Mockito.doThrow(PokemonUpdatedNotExist("")).`when`(pokemonsModifier)?.modify(number, true)
        val body = ""
        givenThereIsAPokemon(number, body,400)
        assertResponsePatch("/pokemons/$number", 400, body,"")
    }

    @Throws(java.lang.Exception::class)
    private fun givenThereIsAPokemon(number: String, body: String, code:Int) {
        assertRequestWithBodyEmpty("PATCH", "/pokemons/$number", body, code)
    }
}