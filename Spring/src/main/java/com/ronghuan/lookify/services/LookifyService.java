package com.ronghuan.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ronghuan.lookify.models.Lookify;
import com.ronghuan.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository LookifyRepo;
	
	public LookifyService(LookifyRepository LookifyRepo) {
		this.LookifyRepo = LookifyRepo;
	}
	
	
	// CREATE & UPDATE
	public Lookify saveSong(Lookify l) {
		return LookifyRepo.save(l);
	}
	
	// GET ALL
	public List<Lookify> getAll(){
		return LookifyRepo.findAll();
	}
	
	// GET ONE
	public Lookify getOne(Long id){
		return LookifyRepo.findById(id).orElse(null);
	}
	
	// DELETE
	public void delete(Long id) {
		LookifyRepo.deleteById(id);
	}
	
	
	//--------- FIND A LIST OF TOP TEN SONGS ---------
	public List<Lookify> topTenSongs(){
		return LookifyRepo.findTop10ByOrderByRatingDesc();
	}
	
	// --------- FIND A LIST OF SONGS BY A ARTIST ---------
	public List<Lookify> searchByArtist(String artist){
		return LookifyRepo.findByArtistContaining(artist);
	}
	
	
	
	
	
	
	
	
}
