package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");

        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            int removeNum = queue.poll();
            sb.append(removeNum).append(", ");
        }

        int removeNum = queue.poll();
        sb.append(removeNum).append(">");
        System.out.println(sb);
    }
}
