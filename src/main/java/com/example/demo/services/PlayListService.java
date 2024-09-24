package com.example.demo.services;

import java.util.List;

import com.example.demo.entites.Playlist;
import com.example.demo.entites.Song;

public interface PlayListService {

	public void addPlayList(Playlist playlist);

	public List<Playlist> fetchPlaylist();
}
