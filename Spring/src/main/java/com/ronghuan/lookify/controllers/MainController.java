package com.ronghuan.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronghuan.lookify.models.Lookify;
import com.ronghuan.lookify.services.LookifyService;

@Controller
public class MainController {
	@Autowired
	private LookifyService lookifyServ;
	
	
	// DISPLAY HOME PAGE
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	//-------------------------------------- READ ALL ------------------------------------------
	// DISPLAY DASHBOARD WITH ALL SONGS
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> allSongs = lookifyServ.getAll();
		model.addAttribute("songs", allSongs);
		return "dashboard.jsp";
	}
	
	//-------------------------------------- CREATE ------------------------------------------
	// SHOW FORM TO CREATE NEW SONG
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("lookifyObj") Lookify emptyLookify) {
		return "create.jsp";
	}
	
	
	// PERFORM THE ACTION TO CREATE A NEW SONG
	@PostMapping("/songs/create")
	public String createSong(
		@Valid @ModelAttribute("lookifyObj") Lookify filledLookify,
		BindingResult results) {
		// validation
		if (results.hasErrors()) {
			return "create.jsp";
		} else {
			lookifyServ.saveSong(filledLookify);
			return "redirect:/dashboard";
		}
	}
	
	//-------------------------------------- READ ------------------------------------------
	@GetMapping("/songs/{id}")
	public String readSong(Model model, @PathVariable("id") Long id) {
		// find single song object
		Lookify song = lookifyServ.getOne(id);
		
		// pass the song into jsp
		model.addAttribute("song", song);
		
		return "song.jsp";
	}
	
	
	//-------------------------------------- DELETE ----------------------------------------
	@GetMapping("/songs/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		lookifyServ.delete(id);		
		return "redirect:/dashboard";
	}	
	
	//------------------------------- SEARCH BY ARTIST -------------------------------------
	@GetMapping("/search")
	public String searchSong(Model model, @RequestParam("artist") String artist) {

		// PASS ARTIST NAME AND  A LIST OF SONGS THE ARTIST HAS
		model.addAttribute("artist", artist);
		model.addAttribute("songs", lookifyServ.searchByArtist(artist));
		return "search.jsp";
	}
	
	
	//------------------------------- SEARCH TOP TEN SONGS ---------------------------------
	@GetMapping("/search/topTen")
	public String searchTopTen(Model model) {
		model.addAttribute("songs", lookifyServ.topTenSongs());
		
		return "top_ten.jsp";
	}
	
	
	
	
	
	
	
	
	
}
