import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] arr = str.split("");
        String answerStr = "";
        Arrays.sort(arr);
        
        for (int i = arr.length-1; i >= 0; i--) {
            answerStr += arr[i];
        }
        
        answer = Long.parseLong(answerStr);
        return answer;
    }
}