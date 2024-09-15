package com.example.demo.services;

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

}
