import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] intArr = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(intArr);
        String min = Integer.toString(intArr[0]);
        String max = Integer.toString(intArr[intArr.length - 1]);
        
        answer = min + " " + max;
        return answer;
    }
}