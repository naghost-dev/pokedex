package com.bitperdido.pokedex.infraestructure.rest.controller

import com.bitperdido.pokedex.domain.Pokemon
import com.bitperdido.pokedex.domain.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
abstract class ApplicationRestTestCase {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    @MockBean
    protected var pokemonRepository: PokemonRepository? = null


    @Throws(Exception::class)
    protected fun assertResponse(
        endpoint: String?,
        expectedStatusCode: Int?,
        expectedResponse: String?
    ) {
        val response: ResultMatcher =
            if (expectedResponse!=null && expectedResponse.isEmpty()) content().string("") else content().json(expectedResponse!!)
        mockMvc?.perform(get(endpoint!!))?.andExpect(status().`is`(expectedStatusCode!!))?.andExpect(response)
    }

    @Throws(Exception::class)
    protected fun assertResponsePatch(
        endpoint: String?,
        expectedStatusCode: Int?,
        body:String?,
        expectedResponse: String?
    ) {
        val response: ResultMatcher =
            if (expectedResponse!=null && expectedResponse.isEmpty()) content().string("") else content().json(expectedResponse!!)
        mockMvc?.perform(patch(endpoint!!).content(body!!).contentType(APPLICATION_JSON))?.andExpect(status().`is`(expectedStatusCode!!))?.andExpect(response)
    }

    @Throws(Exception::class)
    protected fun assertResponse(
        endpoint: String?,
        expectedStatusCode: Int?,
        expectedResponse: String,
        headers: HttpHeaders?
    ) {
        val response: ResultMatcher =
            if (expectedResponse.isEmpty()) content().string("") else content().json(expectedResponse)
        mockMvc?.perform(get(endpoint!!).headers(headers!!))?.andExpect(status().`is`(expectedStatusCode!!))?.andExpect(response)
    }

    @Throws(Exception::class)
    protected fun assertRequestWithBodyEmpty(
        method: String?,
        endpoint: String?,
        body: String,
        expectedStatusCode: Int?
    ) {
        mockMvc
            ?.perform(request(HttpMethod.valueOf(method!!), endpoint!!).content(body).contentType(APPLICATION_JSON))
            ?.andExpect(status().`is`(expectedStatusCode!!))
            ?.andExpect(content().string(""))
    }

    @Throws(Exception::class)
    protected fun assertRequestWithBodySame(
        method: String?,
        endpoint: String?,
        body: String,
        expectedStatusCode: Int?
    ) {
        mockMvc
            ?.perform(request(HttpMethod.valueOf(method!!), endpoint!!).content(body).contentType(APPLICATION_JSON))
            ?.andExpect(status().`is`(expectedStatusCode!!))
            ?.andExpect(content().string(body))
    }

    @Throws(Exception::class)
    protected fun assertRequest(
        method: String?,
        endpoint: String?,
        expectedStatusCode: Int?
    ) {
        mockMvc?.perform(request(HttpMethod.valueOf(method!!), endpoint!!))?.andExpect(status()?.`is`(expectedStatusCode!!))?.andExpect(content().string(""))
    }

    fun getNullPokemon(): Pokemon {
        return Pokemon(null, null, null, null, null,null,null,null,null,null,null,null,null,null)
    }

    fun getEmptyPokemon(): Pokemon {
        return Pokemon(null, "", "", emptyList(), false,"","", emptyList(),0,0,0.0,0.0,0.0,0.0)
    }

    fun getCompletePokemon(): Pokemon {

        val cyndaquil = Pokemon(null,
            "155",
            "Cyndaquil ", listOf("fire"),
            false,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png",
            listOf(),
            100,
            100,
            19.0,
            19.0,
            0.9,
            0.9)

        return cyndaquil
    }
}