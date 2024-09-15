package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService {

	@Autowired
	SongRepository songRepository;

	@Override
	public String addSong(Song song) {

		songRepository.save(song);
		return "song saved successfully";
	}

	@Override
	public boolean songExists(String name) {
		Song song = songRepository.findByName(name);

		if (song == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songList = songRepository.findAll();
		return songList;
	}
}
