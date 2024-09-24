package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Playlist;
import com.example.demo.entites.Song;
import com.example.demo.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {

	@Autowired
	PlayListRepository playListRepository;

	@Override
	public void addPlayList(Playlist playlist) {
		playListRepository.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchPlaylist() {
		List<Playlist> songList = playListRepository.findAll();
		return songList;
	}
}
