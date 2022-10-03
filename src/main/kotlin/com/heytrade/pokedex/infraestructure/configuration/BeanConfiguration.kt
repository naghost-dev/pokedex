package com.heytrade.pokedex.infraestructure.configuration

import com.heytrade.pokedex.application.find.PokemonsFinderService
import com.heytrade.pokedex.application.get.PokemonsGetterService
import com.heytrade.pokedex.application.modify.PokemonsModifierService
import com.heytrade.pokedex.domain.PokemonRepository
import com.heytrade.pokedex.domain.pokedex.service.find.PokemonsFinder
import com.heytrade.pokedex.domain.pokedex.service.get.PokemonsGetter
import com.heytrade.pokedex.domain.pokedex.service.modify.PokemonsModifier
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