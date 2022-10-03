package com.heytrade.pokedex

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
@EnableAutoConfiguration
class PokedexApplication

fun main(args: Array<String>) {
	runApplication<PokedexApplication>(*args)
}
