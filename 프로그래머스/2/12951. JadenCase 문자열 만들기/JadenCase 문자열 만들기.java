import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int backcnt = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') backcnt += 1;
            else break;
        }
        
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.isBlank()) {
                sb.append(" ");
            } else {
                sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1, str.length()).toLowerCase());
                if (i != arr.length-1) sb.append(" ");
                else { 
                    for (int j = 0; j < backcnt; j++) {
                        sb.append(" ");
                    }
                }
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}