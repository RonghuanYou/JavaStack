package com.ronghuan.pokemon_test;

public class PokemonTest {

	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();
		
		Pokemon charmeleon = pokedex.createPokemon("charmeleon", 100, "fire");
		Pokemon squirtle = pokedex.createPokemon("squirtle", 100, "water");
		System.out.println(pokedex.pokemonInfo(squirtle));
		System.out.println(pokedex.pokemonInfo(charmeleon));

		System.out.println("\n------squirtle got attacked by charmeleon--------");
		charmeleon.attackPokemon(squirtle);
		System.out.println(pokedex.pokemonInfo(squirtle));
		
		System.out.println("\n------All Pokemon we created--------");
		pokedex.listPokemon();
	}
}
