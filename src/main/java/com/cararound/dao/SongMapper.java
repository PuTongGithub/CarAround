package com.cararound.dao;

import java.util.List;

import com.cararound.entity.Song;

public interface SongMapper {
	public void insertSelective(Song song);
	
	public List<Song> selectSongs();
	
	public Song selectByMid(String mid);
	
	public void deleteByMid(String mid);
}