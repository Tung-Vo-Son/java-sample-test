package sampleTest2.task2;

import java.math.BigInteger;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        String test = "my.song.mp3 11b" + "\n" +
                "greatSong.flac 1000b" + "\n" +
                "not3.txt 5b" + "\n" +
                "video.mp4 200b" + "\n" +
                "game.exe 100b" + "\n" +
                "mov!e.mkv 10000b";
        System.out.println(new Solution().solution(test));
    }

    public String solution(String s){
        Set<String> music = new HashSet<String>(Arrays.asList("mp3", "aac", "flac"));
        Set<String> image = new HashSet<String>(Arrays.asList("jpg", "bmp", "gif"));
        Set<String> movie = new HashSet<String>(Arrays.asList("mp4", "avi", "mkv"));
        Set<String> other = new HashSet<String>();

        Map<String, Integer> files = new HashMap<>();
        files.put("music", 0);
        files.put("image", 0);
        files.put("movie", 0);
        files.put("other", 0);

        // Split seperate file in each line
        String[] filePlusSize = s.split("\n");
        for(int i=0; i<filePlusSize.length;i++){
            String file = filePlusSize[i].substring(filePlusSize[i].lastIndexOf(".") + 1, filePlusSize[i].length() - 1);
            String[] x = file.split("\\s+");
            String fileType = x[0];                                 // file type
            String fileSize = x[1].substring(0, x[1].length());     // byte size
            if (music.contains(fileType)) {
                    files.put("music", files.get("music") + Integer.parseInt(fileSize));
                } else if (image.contains(fileType)) {
                    files.put("image", files.get("image") + Integer.parseInt(fileSize));
                } else if (movie.contains(fileType)) {
                    files.put("movie", files.get("movie") + Integer.parseInt(fileSize));
                } else {
                    files.put("other", files.get("other") + Integer.parseInt(fileSize));
                }
        }

        String result = "music " + files.get("music").toString() + "b\n" +
                "image " + files.get("image").toString() + "b\n" +
                "movie " + files.get("movie").toString() + "b\n" +
                "other " + files.get("other").toString() +"b";
        return result;
    }
}
