import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for (int i = 0; i < cards1.length; i++) {
            q1.offer(cards1[i]);
        }
        
        for (int i = 0; i < cards2.length; i++) {
            q2.offer(cards2[i]);
        }
        
        for (String str : goal) {
            if (str.equals(q1.peek())) {
                q1.poll();
                continue;
            }
            
            if (str.equals(q2.peek())) {
                q2.poll();
                continue;
            }
            
            return "No";
        }
        return "Yes";
    }
}