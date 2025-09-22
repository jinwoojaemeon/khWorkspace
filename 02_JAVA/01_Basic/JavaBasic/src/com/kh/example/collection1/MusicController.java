package com.kh.example.collection1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MusicController {
	private List<Music> list = new ArrayList<>();
	
	public int addList(Music music) {
		if(music != null) {
			list.add(music);
			return 1;
		}else {
			return -1;
		}
	}
	public int addAtZero(Music music) {
		if(music != null) {
			list.add(0, music);
			return 1;
		}else {
			return -1;
		}
	}
	
	public List<Music> printAll(){
		return list;
	}
	
	public Music searchMusic(String title) {	
		for(Music music : list) {
			if(music.getTitle().equals(title)) {
				return music;
			}
		}
//		for(int i=0; i<list.size(); i++) {
//			Music m = (Music)list.get(i);
//			if(m.getTitle().equals(title)) {
//				return (Music)list.get(i);
//			}
//		}
		return null;
	}
	
	public Music removeMusic(String title) {
		for(int i=0; i<list.size(); i++) {
			Music m = list.get(i);
			if(m.getTitle().equals(title)) {
				list.remove(m);
				return m;
			}
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		for(int i=0; i<list.size(); i++) {
			Music m = list.get(i);
			if(m.getTitle().equals(title)) {
				list.set(i, m);
				return m;
			}
		}
		return null;
	}
	
	public int ascTitle() {
        try {
            Collections.sort(list, new AscTitle());
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public int descSinger() {
        try {
            // 가수명 내림차순, 동일 가수시 곡명 오름차순
            Collections.sort(list, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Music m1 = (Music)o1;
                    Music m2 = (Music)o2;
                    int singerCompare = m2.getSinger().compareTo(m1.getSinger()); // 내림차순
                    if (singerCompare != 0) {
                        return singerCompare;
                    }
                    return m1.getTitle().compareTo(m2.getTitle()); // 곡명은 오름차순
                }
            });
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
}
