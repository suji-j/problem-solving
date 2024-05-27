class Solution {
    public int solution(int num) {
        long ln = Long.valueOf(num);
        int cnt = 0;
        
        while(ln != 1) {
            if (cnt > 500) {
                return -1;
            }
            
            ln = (ln % 2 == 0) ? ln / 2 : ln * 3 + 1;
            cnt++;
        }
        
        return cnt;
    }
}