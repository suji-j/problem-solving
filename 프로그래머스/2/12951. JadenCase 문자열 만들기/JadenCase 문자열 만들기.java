import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        int backCnt = 0;
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') backCnt += 1;
            else break;
        }
        
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            
            if (str.isBlank()) {
                sb.append(" ");
            } else {
                sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1, str.length()).toLowerCase());
                if (i != arr.length - 1) sb.append(" ");
                else { 
                    for (int j = 0; j < backCnt; j++) {
                        sb.append(" ");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}