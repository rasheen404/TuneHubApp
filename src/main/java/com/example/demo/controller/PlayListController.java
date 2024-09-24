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
		playListService.addPlayList(playlist);
		List<Song> songsList = playlist.getSong();
		for (Song song : songsList) {
			song.getPlaylist().add(playlist);
			songService.updateSong(song);
		}

		return "playListSuccess";
	}
	
	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> playlist = playListService.fetchPlaylist();
		System.err.println("------------------------"+playlist);
		model.addAttribute("playlist", playlist);
		return "viewPlaylist";
		
	
	

}
}
