package com.ronghuan.pokemon_test;

public class Pokemon {
	// ATTRIBUTES
	protected String name;
	protected int health;
	protected String type;
	
	
	// STATIC:
	private static int pokemonCount;
	
	// CONSTRUCTOR
	public Pokemon(String name, int health, String type) {
		super();
		this.name = name;
		this.health = health;
		this.type = type;
		// INCREASE NUMBER OF POKEMON
		Pokemon.pokemonCount += 1;
	}

	
	// GETTERS/SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getPokemonCount() {
		return pokemonCount;
	}


	// METHODS
	public void attackPokemon(Pokemon pokemon) {
		pokemon.health -= 10;
	}

}
