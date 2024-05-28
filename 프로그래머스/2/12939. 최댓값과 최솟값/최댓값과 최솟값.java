import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        int[] intArr = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(intArr);
        String min = Integer.toString(intArr[0]);
        String max = Integer.toString(intArr[intArr.length - 1]);
        
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}