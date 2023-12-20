package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            str = str.trim();
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.add(Character.toString(str.charAt(i)));
                }

                if (stack.isEmpty()) {
                     if (str.charAt(i) == ')' || str.charAt(i) == ']') {
                        stack.add(Character.toString(str.charAt(i)));
                        break;
                    }
                } else {
                    if (str.charAt(i) == ')' && stack.peek().equals("(")) {
                        stack.pop();
                    } else if (str.charAt(i) == ']' && stack.peek().equals("[")) {
                        stack.pop();
                    } else if (str.charAt(i) == ')' && stack.peek().equals("[")) {
                        break;
                    } else if (str.charAt(i) == ']' && stack.peek().equals("(")) {
                        break;
                    }
                }

            }

            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}
