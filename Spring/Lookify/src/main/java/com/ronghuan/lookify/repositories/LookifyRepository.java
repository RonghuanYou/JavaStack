package com.ronghuan.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronghuan.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	List<Lookify> findTop10ByOrderByRatingDesc();
	List<Lookify> findByArtistContaining(String artist);
}




