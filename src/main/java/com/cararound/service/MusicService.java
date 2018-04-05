package com.cararound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cararound.dao.SongMapper;
import com.cararound.entity.Song;

@Service
public class MusicService {
	@Autowired
	SongMapper songMapper;

	public List<Song> getSongs() {
		return songMapper.selectSongs();
	}

	public void addLike(Song song) {
		songMapper.insertSelective(song);
	}

	public void cancelLike(String mid) {
		songMapper.deleteByMid(mid);
	}

	public boolean findSong(String mid) {
		if (songMapper.selectByMid(mid) != null) {
			return true;
		} else {
			return false;
		}
	}
}
