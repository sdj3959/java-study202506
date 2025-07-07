package chap2_4.collection.song;

import java.util.HashSet;
import java.util.Set;

// 가수
public class Artist {

    private final String artistName; // 가수명
    private final Set<String> songList; // 노래목록

    public Artist(String artistName) {
        this.artistName = artistName;
        this.songList = new HashSet<>();
    }

    // 노래를 갖다주면 노래목록에 저장하는 메서드
    public boolean addSong(String songName) {
        return this.songList.add(songName);
    }

    public Set<String> getSongList() {
        return songList;
    }
}