import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for (int j = score.length - m; j >= 0; j -= m) {
            answer += (score[j] * m);
        }
        
        return answer;
    }
}