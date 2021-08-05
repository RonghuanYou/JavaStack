package com.ronghuan.pokemon_test;

public class Pokedex extends AbstractPokemon{
	// inherits myPokemons List from its parent class
	@Override
	public void listPokemon() {
		for(Object pokemon : myPokemons) {
			System.out.println(pokemon);
		}
	}
}
