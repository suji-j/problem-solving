class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0, y = 0;
        String[] strArr = s.split("");
        
        for (int n = 0; n < strArr.length; n++) {
            char alpa = strArr[n].charAt(0);
            if (alpa == 'p' || alpa == 'P') {
                p++;
            } else if (alpa == 'y' || alpa == 'Y') {
                y++;
            }
        }
        
        if (p == y) answer = true; 
        else answer = false;

        return answer;
    }
}