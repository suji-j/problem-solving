import java.util.List;
import java.util.ArrayList;

class Solution { 
    public String solution(String s, String skip, int index) {
        List<Character> skipList = new ArrayList<>();
        char[] cList = s.toCharArray();
        
        for (int i = 0; i < skip.length(); i++) {
            skipList.add(skip.charAt(i));
        }
        
        for (int i = 0; i < cList.length; i++) {
            int cnt = 0;
            
            while (cnt < index) {
                cList[i] += 1;

                if (cList[i] > 'z') {
                    cList[i] = 'a';
                }

                if (!skipList.contains(cList[i])) {
                    cnt += 1;
                }
            }
        }
        
        String str = new String(cList);
        return str;
    }
}