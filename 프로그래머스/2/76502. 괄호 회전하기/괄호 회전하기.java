import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
        }

        if (check(new LinkedList<>(q))) answer++;
        for (int i = 0; i < s.length() - 1; i++) {
            q.add(q.poll());
            if (check(new LinkedList<>(q))) answer++;
        }
        
        return answer;
    }
    
    static boolean check(Queue<Character> queue) {
        Stack<Character> s = new Stack<>();

        while (!queue.isEmpty()) {
            char cur = queue.poll();

            if (s.isEmpty() && (cur == '}' || cur == ']' || cur == ')')) {
                return false;
            }

            if (cur == '{' || cur == '[' || cur == '(') {
                s.add(cur);
            } else if (cur == '}' && s.peek() == '{') {
                s.pop();
            } else if (cur == ']' && s.peek() == '[') {
                s.pop();
            } else if (cur == ')' && s.peek() == '(') {
                s.pop();
            }
        }
        return s.isEmpty();
    }
}

