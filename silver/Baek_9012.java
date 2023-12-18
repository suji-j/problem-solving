package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<String> stack = new Stack<>();
            boolean over = false;
            String PS = br.readLine();
            String[] arrPS = PS.split("");

            for (String arrP : arrPS) {
                if (arrP.equals("(")) {
                    stack.push(arrP); //
                } else if (!stack.isEmpty() && arrP.equals(")")) {
                    stack.pop();
                } else if (stack.isEmpty() && arrP.equals(")")) {
                    over = true;
                }
            }

            if (over || !stack.isEmpty()) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }
}
