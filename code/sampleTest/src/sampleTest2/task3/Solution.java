package sampleTest2.task3;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    public int solution(String S, String T){
        String[] timeS = S.split(":");
        String[] timeT = T.split(":");
        int result = 0;
        if(Integer.parseInt(timeS[0]) > Integer.parseInt(timeT[0])) return 0;
        int hour = Integer.parseInt(timeS[0]);
        int min = Integer.parseInt(timeS[1]);
        int sec = Integer.parseInt(timeS[2]);
        String s="";        // 15:15:00 ->151500
        String hs="";
        String ms="";
        String ss="";
        while (!(hour==Integer.parseInt(timeT[0]) && min==Integer.parseInt(timeT[1]) && sec==Integer.parseInt(timeT[2]))){
            if(hour<10) hs="0" + Integer.toString(hour);
            else hs = Integer.toString(hour);
            if(min<10) ms="0" + Integer.toString(min);
            else hs = Integer.toString(min);
            if(sec<10) ss="0" + Integer.toString(sec);
            else ss = Integer.toString(sec);

            s = hs + ms + ss;

            // Set to check how many digit
            Set<Character> digit = new HashSet<>();
            for(int i=0;i<s.length();i++){
                digit.add(s.charAt(i));
            }
            if (digit.size()<=2) result++;

            if(sec <59) sec++;
            else{
                sec=0;
                min++;
                if(min>59)
                {
                    min=0;
                    hour++;
                    if(hour > 23){
                        hour=0;
                    }
                }
            }
        }

        // Check the end time
        Set<Character> endTimeDigit = new HashSet<>();
        for(int i=0;i<T.length();i++){
            endTimeDigit.add(T.charAt(i));
        }
        if (endTimeDigit.size()<=3) result++;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().solution("15:15:00", "15:15:12"));
        System.out.println(new Solution().solution("22:22:21", "22:22:23"));
    }
}
