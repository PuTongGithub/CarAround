package com.cararound.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cararound.entity.Song;
import com.cararound.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {
	
	@Autowired
	MusicService musicService;
	
	@RequestMapping("/getSongs")
	public List<Song> getSongs(){
		return musicService.getSongs();
	}
	
	@RequestMapping("/addLike")
	public Map<String, Object> addLike(@RequestBody Song song) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(musicService.findSong(song.getMid())) {
			map.put("success", false);
			map.put("message", "歌曲已存在！");
		}
		else {
			musicService.addLike(song);
			map.put("success", true);
			map.put("message", "添加成功！");
		}
		return map;
	}
	
	@RequestMapping("/cancelLike")
	public void cancelLike(String mid) {
		musicService.cancelLike(mid);
	}
}
