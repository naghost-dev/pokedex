package com.heytrade.pokedex.infraestructure.rest.controller.pokemon_modifier

import com.heytrade.pokedex.domain.pokedex.error.modify.PokemonUpdatedNotExist
import com.heytrade.pokedex.domain.pokedex.service.modify.PokemonsModifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
class PokemonsModifyController(@Autowired private val pokemonsModifier: PokemonsModifier) {

    @PatchMapping("/pokemons/{number}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun index(@PathVariable number: String, @RequestBody pokemonModifyRequest: PokemonsModifyRequest) {
        pokemonsModifier.modify(number, pokemonModifyRequest.favorite)

    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 409
    @ExceptionHandler(PokemonUpdatedNotExist::class)
    fun pokemonNotExist() {
        // Nothing to do
    }

}