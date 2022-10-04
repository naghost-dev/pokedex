package com.bitperdido.pokedex.infraestructure.configuration

import com.bitperdido.pokedex.application.find.PokemonsFinderService
import com.bitperdido.pokedex.application.get.PokemonsGetterService
import com.bitperdido.pokedex.application.modify.PokemonsModifierService
import com.bitperdido.pokedex.domain.PokemonRepository
import com.bitperdido.pokedex.domain.pokedex.service.find.PokemonsFinder
import com.bitperdido.pokedex.domain.pokedex.service.get.PokemonsGetter
import com.bitperdido.pokedex.domain.pokedex.service.modify.PokemonsModifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun pokemonsFinder(pokemonRepository: PokemonRepository): PokemonsFinder? {
        return PokemonsFinderService(pokemonRepository)
    }

    @Bean
    fun pokemonsGetter(pokemonRepository: PokemonRepository): PokemonsGetter? {
        return PokemonsGetterService(pokemonRepository)
    }
    @Bean
    fun pokemonsModifier(pokemonRepository: PokemonRepository): PokemonsModifier? {
        return PokemonsModifierService(pokemonRepository)
    }

}