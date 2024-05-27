import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int length = arr.length - 1;
        
        if(length == 0) {
            arr[0] = -1;
            return arr;
        } else {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
            
            int idx = 0;
            for (int i = 0 ; i < arr.length; i++) {
                if (arr[i] != min) {
                    answer[idx] = arr[i];
                    idx++;
                }
            }
        }
        
        return answer;
    }
}