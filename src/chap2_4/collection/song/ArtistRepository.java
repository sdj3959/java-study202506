package chap2_4.collection.song;

import java.util.Map;
import java.util.Set;

// 가수 객체를 자료구조로 관리하는 클래스
public class ArtistRepository {

    // 가수들을 담을 자류구조
    // key: 가수명, value: 가수 객체
    private Map<String, Artist> artistMap;

    private int count;

    public int count() {
        if (artistMap != null) {
            Set<String> keys = artistMap.keySet();
            for (String key : keys) {
                if (key.equals("artist")) count++;
            }
            return count;
        }
        return 0;
    }
    public void addArtist(Artist artist) {}
}
