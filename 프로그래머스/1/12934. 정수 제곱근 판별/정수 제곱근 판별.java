class Solution {
    public long solution(long n) {
        long answer = 0;
        double db = Math.sqrt(n);
        
        if(db % 1 == 0) {
            answer = (long) Math.pow(db+1, 2);
        } else {
            answer = -1;
        }
        
        return answer;
    }
}