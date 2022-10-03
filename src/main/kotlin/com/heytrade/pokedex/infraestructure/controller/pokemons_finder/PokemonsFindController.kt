package com.heytrade.pokedex.infraestructure.rest.controller.pokemons_finder

import com.heytrade.pokedex.domain.pokedex.service.find.PokemonsFinder
import com.heytrade.pokedex.infraestructure.rest.controller.PokemonsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PokemonsFindController (@Autowired private val pokemonsFinder: PokemonsFinder){

    @GetMapping("/pokemons")
    fun index(@RequestParam(required = false) name : String?, @RequestParam(required = false) favorite: Boolean?, @RequestParam(required = false) type : List<String>?) : List<PokemonsResponse>?{
        return pokemonsFinder.find(name, favorite,  type)?.map{pokemon->PokemonsResponse(pokemon)}
    }


}