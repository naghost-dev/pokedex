package com.heytrade.pokedex.infraestructure.rest.controller.pokemons_getter

import com.heytrade.pokedex.domain.pokedex.service.get.PokemonsGetter
import com.heytrade.pokedex.infraestructure.rest.controller.ApplicationRestTestCase
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean

class PokemonGetControllerTest() : ApplicationRestTestCase() {

    @Autowired
    @MockBean
    protected var pokemonGetter: PokemonsGetter? = null

    @Test
    @Throws(Exception::class)
    fun find_an_existing_pokemon() {

        Mockito.`when`(pokemonGetter?.get("151")).thenReturn(getCompletePokemon())
        val id = "151"
        val body= "{\"number\":\"155\",\"name\":\"Cyndaquil \",\"type\":[\"fire\"],\"favorite\":false,\"imgUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"soundUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"evolutions\":[],\"cp\":100,\"hp\":100,\"minWeight\":19.0,\"maxWeight\":19.0,\"minHeight\":0.9,\"maxHeight\":0.9}"
        givenThereIsAPokemon(id, body)
        assertResponse(String.format("/pokemons/%s", id), 200, body)
    }

    @Test
    @Throws(Exception::class)
    fun find_an_not_existing_pokemon() {

        Mockito.`when`(pokemonGetter?.get("152")).thenReturn(null)
        val id = "152"
        val body= ""
        givenThereIsAPokemon(id, body)
        assertResponse(String.format("/pokemons/%s", id), 200, body)
    }

    @Throws(java.lang.Exception::class)
    private fun givenThereIsAPokemon(id: String, body: String) {
        assertRequestWithBodySame("GET", String.format("/pokemons/%s", id), body, 200)
    }
}