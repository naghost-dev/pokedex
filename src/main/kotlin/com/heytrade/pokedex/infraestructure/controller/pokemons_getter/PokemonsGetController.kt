package com.heytrade.pokedex.infraestructure.rest.controller.pokemons_getter

import com.heytrade.pokedex.domain.Pokemon
import com.heytrade.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist
import com.heytrade.pokedex.domain.pokedex.service.get.PokemonsGetter
import com.heytrade.pokedex.infraestructure.rest.controller.PokemonsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class PokemonsGetController (@Autowired private val pokemonsGetter: PokemonsGetter){

    @GetMapping("/pokemons/{number}")
    fun index(@PathVariable number:String): PokemonsResponse?{
        val pokemon : Pokemon? =pokemonsGetter.get(number)
        if (pokemon!=null){
            return PokemonsResponse(pokemon)
        }
       return null
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 409
    @ExceptionHandler(PokemonUpdatedNotExist::class)
    fun pokemonNotExist() {
        // Nothing to do
    }
}