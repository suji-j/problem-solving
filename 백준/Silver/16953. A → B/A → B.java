import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long value;
        int count;

        public Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(bfs(A, B));
    }

    static int bfs(long A, long B) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.value == B) {
                return cur.count;
            }

            long next1 = cur.value * 2;
            if (next1 <= B) {
                queue.add(new Node(next1, cur.count + 1));
            }

            long next2 = cur.value * 10 + 1;
            if (next2 <= B) {
                queue.add(new Node(next2, cur.count + 1));
            }
        }

        return -1;
    }
}