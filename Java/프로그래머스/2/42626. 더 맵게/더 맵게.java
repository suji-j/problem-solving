
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        float sco = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(scoville);
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;
            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
        }
        
        return answer;
    }
}