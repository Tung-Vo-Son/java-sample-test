package sampleTest1.task2;

import java.util.*;

public class Solution {

    public int solution(String S){
        // Find all substring from S
        List<String> s1 = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            for(int j=i+1;j<=S.length();j++){
                if(i!=j){
                    s1.add(S.substring(i,j));
                }
            }
        }
//        System.out.println(s1);

        // SubString + frequency of occurrence
        Map<String, Integer> s2 = new HashMap<>();
        for(String s : s1){
            s2.put(s, s2.getOrDefault(s,0) + 1);
        }
//        System.out.println(s2);

        // Get substring occur 1 time
        List<String> s3 = new ArrayList<>();
        for(String s : s2.keySet()){
            if(s2.get(s) == 1){
                s3.add(s);
            }
        }
//        System.out.println(s3);

        // Get min length
        int minLength = Integer.MAX_VALUE;
        for(String s : s3){
            minLength = (minLength < s.length()) ? minLength : s.length();
        }
        return minLength;
    }


    public static void main(String[] args)
    {
        System.out.println(new Solution().solution("abaaba"));      // 2
        System.out.println(new Solution().solution("zyzyzyz"));     // 5
        System.out.println(new Solution().solution("aabbbabaaa"));  // 3
    }
}

