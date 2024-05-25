import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = -1;
        Stack<String> stack = new Stack<String>();
        String[] arr = s.split("");
        stack.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (!stack.empty()) {
                if (stack.peek().equals(arr[i])) stack.pop();
                else stack.push(arr[i]);
            } else {
                stack.push(arr[i]);
            }
        }
        return answer = (stack.empty()) ? 1 : 0;
    }
}