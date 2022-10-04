package com.bitperdido.pokedex.infraestructure.rest.controller.pokemon_modifier

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonsModifyRequest (@JsonProperty("favorite") var favorite : Boolean) {
}