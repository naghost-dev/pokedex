package com.bitperdido.pokedex.infraestructure.rest.controller.pokemons_finder

import com.bitperdido.pokedex.domain.pokedex.service.find.PokemonsFinder
import com.bitperdido.pokedex.infraestructure.rest.controller.ApplicationRestTestCase
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean

internal class PokemonsFindControllerTest: ApplicationRestTestCase() {

    @Autowired
    @MockBean
    protected var pokemonsFinder: PokemonsFinder? = null


    @Test
    @Throws(Exception::class)
    fun find_an_existing_pokemon_partial() {

        Mockito.`when`(pokemonsFinder?.find("cyn",null,null)).thenReturn(listOf(getCompletePokemon()))
        val name = "cyn"

        val body= "[{\"number\":\"155\",\"name\":\"Cyndaquil \",\"type\":[\"fire\"],\"favorite\":false,\"imgUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"soundUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"evolutions\":[],\"cp\":100,\"hp\":100,\"minWeight\":19.0,\"maxWeight\":19.0,\"minHeight\":0.9,\"maxHeight\":0.9}]"
        givenThereIsAPokemon(name, body)
        assertResponse(String.format("/pokemons/?name=%s", name), 200, body)
    }

    @Test
    @Throws(Exception::class)
    fun find_an_existing_pokemon_partial1() {
        val name = "cyn"
        val favorite=true
        Mockito.`when`(pokemonsFinder?.find(name,favorite,null)).thenReturn(listOf(getCompletePokemon()))
        val body= "[{\"number\":\"155\",\"name\":\"Cyndaquil \",\"type\":[\"fire\"],\"favorite\":false,\"imgUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"soundUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"evolutions\":[],\"cp\":100,\"hp\":100,\"minWeight\":19.0,\"maxWeight\":19.0,\"minHeight\":0.9,\"maxHeight\":0.9}]"
        givenThereIsAPokemon(name,favorite, body)
        assertResponse("/pokemons/?name=$name&favorite=$favorite", 200, body)
    }

    @Test
    @Throws(Exception::class)
    fun find_an_existing_pokemon() {
        val name = "cyn"
        val favorite=true
        val types = "fire"
        Mockito.`when`(pokemonsFinder?.find(name,favorite, listOf(types))).thenReturn(listOf(getCompletePokemon()))
        val body= "[{\"number\":\"155\",\"name\":\"Cyndaquil \",\"type\":[\"fire\"],\"favorite\":false,\"imgUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"soundUrl\":\"https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png\",\"evolutions\":[],\"cp\":100,\"hp\":100,\"minWeight\":19.0,\"maxWeight\":19.0,\"minHeight\":0.9,\"maxHeight\":0.9}]"
        givenThereIsAPokemon(name,favorite,types, body)
        assertResponse("/pokemons/?name=$name&favorite=$favorite&type=$types", 200, body)
    }

    @Test
    @Throws(Exception::class)
    fun find_an_not_existing_pokemon() {
        val name = "152"
        Mockito.`when`(pokemonsFinder?.find(name,null,null)).thenReturn(null)
        val body= ""
        givenThereIsAPokemon(name, body)
        assertResponse("/pokemons/?name=$name", 200, body)
    }

    @Throws(java.lang.Exception::class)
    private fun givenThereIsAPokemon(name: String,  body: String) {
        assertRequestWithBodySame("GET", "/pokemons/?name=$name", body, 200)
    }
    @Throws(java.lang.Exception::class)
    private fun givenThereIsAPokemon(name: String, favorite:Boolean?, body: String) {
        assertRequestWithBodySame("GET", "/pokemons/?name=$name&favorite=$favorite", body, 200)
    }

    @Throws(java.lang.Exception::class)
    private fun givenThereIsAPokemon(name: String, favorite:Boolean?, types: String, body: String) {
        assertRequestWithBodySame("GET", "/pokemons/?name=$name&favorite=$favorite&type=$types", body, 200)
    }
}