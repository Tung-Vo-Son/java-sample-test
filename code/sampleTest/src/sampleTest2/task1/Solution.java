package sampleTest2.task1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] arrRank){

        // Find rank
        Set<Integer> setRank = new HashSet<Integer>();
        for(int rank : arrRank){
            setRank.add(rank);
        }

        int numOfSoldierReport = 0;

        for(int x : arrRank){
            if (setRank.contains(x+1)){
                numOfSoldierReport ++;
            }
        }
        return numOfSoldierReport;
    }

    public static void main(String[] args) {
        int testRank1[] = {3,4,3,0,2,2,3,0,0};
        System.out.println(new Solution().solution(testRank1));     // 5
        int testRank2[] = {4,2,0};
        System.out.println(new Solution().solution(testRank2));     // 0
        int testRank3[] = {4,4,3,3,1,0};
        System.out.println(new Solution().solution(testRank3));     // 3
    }
}
