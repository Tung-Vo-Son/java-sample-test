package sampleTest1.task3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean solution(int[] A, int[] B){

        // Create list of vector of AB -> A[1,3,2,4], B[4,1,3,2] -> listVector = 14, 31, 23, 42
        List<String> listVector = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            listVector.add(Integer.toString(A[i]) + Integer.toString(B[i]));
        }

        // Create string to check if cycle -> 14422331
        String cycleVector = listVector.get(0);      // cycleVector = 14
        listVector.remove(0);
        for(int i=0;i<A.length;i++){
            String removeElement = "";
            for (String s: listVector){
                if(cycleVector.charAt(cycleVector.length()-1) == s.charAt(0)){
                    cycleVector += s;
                    removeElement = s;
                }
            }
            listVector.remove(removeElement);
        }
//        System.out.println(cycleVector);

        // Check if cycled
        if(cycleVector.charAt(0)  == cycleVector.charAt(cycleVector.length()-1) && cycleVector.length() == A.length*2){
            return true;
        }else return false;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 3, 2, 4}, new int[]{4,1,3,2}));                 // true
        System.out.println(new Solution().solution(new int[]{3, 1, 2}, new int[]{2, 3, 1}));                    // true
        System.out.println(new Solution().solution(new int[]{1, 2, 1}, new int[]{2, 3, 3}));                    // false
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 4}));              // false
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}));              // false
        System.out.println(new Solution().solution(new int[]{1, 2, 2, 3, 3}, new int[]{2, 3, 3, 4, 5}));        // false
    }
}
