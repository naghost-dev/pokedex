package com.heytrade.pokedex.application

import com.heytrade.pokedex.domain.Pokemon
import com.heytrade.pokedex.domain.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean


@SpringBootTest
abstract class ApplicationTestCase {


    @Autowired
    @MockBean
    protected var pokemonRepository: PokemonRepository? = null


    fun getNullPokemon(): Pokemon {
        return Pokemon(null ,null, null, null, null,null,null,null,null,null,null,null,null,null)
    }

    fun getEmptyPokemon(): Pokemon {
        return Pokemon("","", "", emptyList(), false,"","", emptyList(),0,0,0.0,0.0,0.0,0.0)
    }

    fun getCompletePokemon(): Pokemon {

        val cyndaquil = Pokemon(
            "1",
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