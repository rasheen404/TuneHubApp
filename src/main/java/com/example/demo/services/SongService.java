package com.example.demo.services;

import java.util.List;

import com.example.demo.entites.Song;

public interface SongService {

	public String addSong(Song song);

	public boolean songExists(String name);

	public List<Song> fetchAllSongs();
}
