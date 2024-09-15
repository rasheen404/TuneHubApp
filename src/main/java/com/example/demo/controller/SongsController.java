package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Song;
import com.example.demo.services.SongService;

@Controller
public class SongsController {

	@Autowired
	SongService songService;

	@PostMapping("/addSong")
	public String addSongs(@ModelAttribute Song song) {
		songService.addSong(song);
		return "adminHome";

	}

}
