package com.ronghuan.pokemon_test;

import java.util.ArrayList;


public abstract class AbstractPokemon implements PokemonInterface{
	ArrayList<Object> myPokemons = new ArrayList<Object>();

	// INTERFACES
	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon pokemon = new Pokemon(name, health, type);
		myPokemons.add(pokemon.getName());
		return pokemon;
	}

	@Override
	public String pokemonInfo(Pokemon pokemon) {
		return "Pokemon Name: " + pokemon.getName()+ ", Health: " + pokemon.getHealth() + ", Type: "+pokemon.getType();
	}
}
