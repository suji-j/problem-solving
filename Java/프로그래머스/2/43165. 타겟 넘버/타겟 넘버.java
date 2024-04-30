import java.util.LinkedList;

class Solution {
    int cnt;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    
    public void dfs(int[] numbers, int target, int depth, int result) {
        if (depth == numbers.length) {
            if (target == result) {
                cnt++;
            }
            return;
        }
        
        int plus = result + numbers[depth];
        int minus = result - numbers[depth];
        
        dfs(numbers, target, depth+1, plus);
        dfs(numbers, target, depth+1, minus);
    }
}