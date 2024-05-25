import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}