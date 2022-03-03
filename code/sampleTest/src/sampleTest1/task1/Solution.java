package sampleTest1.task1;
// Fill cup with the most capacity first
public class Solution {
    public int solution(int N, int K){
        int numOfGlass = 0;
        for(int i=N; K>0&&i>0; i--){
            if(K>=i){
                numOfGlass++;
                K -= i;
            }
        }
        return K==0 ? numOfGlass : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(5,8));       // 2
        System.out.println(new Solution().solution(4,10));      // 4
        System.out.println(new Solution().solution(1,2));       // -1
        System.out.println(new Solution().solution(10,5));      // 1
    }
}
