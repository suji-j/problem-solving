class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int div = 0;
        
        while (n >= a) {
            div = n / a;
            answer += div * b;
            n = n - (div * a) + (div * b);
        }
        
        return answer;
    }
}