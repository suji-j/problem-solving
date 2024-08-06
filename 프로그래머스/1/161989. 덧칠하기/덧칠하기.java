class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 1, start = section[0], end = section[0] + m - 1;
        
        for (int i : section) {
            if (start <= i && i <= end) {
                continue;
            } 
            start = i;
            end = i + m - 1;
            cnt++;
        }
        
        return cnt;
    }
}