import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH= new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (minH.size() < 1 && str.equals("D")) continue;
            
            if (str.equals("I")) {
                minH.offer(num);
                maxH.offer(num);
                continue;
            } 
            
            if (num == -1) {
                int min = minH.poll();
                maxH.remove(min);
                continue;
            }
                
            int max = maxH.poll();
            minH.remove(max);
        }
        
        if (minH.size() > 0) {
            answer[0] = maxH.poll();
            answer[1] = minH.poll();
        }
        
        return answer;
    }
}