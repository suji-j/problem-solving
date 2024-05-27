import java.util.Arrays;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        Arrays.sort(arr);
        
        for (int i = arr.length - 1; i > -1; i--) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}