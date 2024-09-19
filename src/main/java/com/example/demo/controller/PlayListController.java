package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.entites.Playlist;
import com.example.demo.entites.Song;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlayListController {
	@Autowired
	PlayListService playListService;

	@Autowired
	SongService songService;

	@GetMapping("/createPlaylist")
	public String createPlayList(Model model) {

		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songList", songList);
		return "createPlaylist";
	}

	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute Playlist playlist) {
		// TODO: process POST request

		return "playListSuccess";
	}

}
