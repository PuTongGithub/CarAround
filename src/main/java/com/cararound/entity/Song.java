package com.cararound.entity;

public class Song {
	private String mid;
	private String title;
	private String singer;
	private String album;
	
	public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
