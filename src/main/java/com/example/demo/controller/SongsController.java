package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Song;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongsController {

	@Autowired
	SongService songService;

	@PostMapping("/addSong")
	public String addSongs(@ModelAttribute Song song) {

		String name = song.getName();
		Boolean songname = songService.songExists(name);

		if (songname == false) {
			songService.addSong(song);
			return "songSuccess";
		} else {
			System.err.println("Duplicate name");
			return "songFail";
		}

	}

	@GetMapping("/viewSong")
	public String viewSongs(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		System.out.println(songList);

		model.addAttribute("songList", songList);

		return "viewSong";
	}

	
	
	@GetMapping("/map-viewsongs")
	public String customerViewSongs(Model model) {
		Boolean primeCustomerStatus = true;
		if(primeCustomerStatus == true) {

			List<Song> songList = songService.fetchAllSongs();
			System.out.println(songList);

			model.addAttribute("songList", songList);

			return "viewSong";
		
		}
		else {
			return "makePayment";
		}
	}
	
}
