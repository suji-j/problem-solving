import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, sec;

        public Node(int vertex, int sec) {
            this.vertex = vertex;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node o) {
            return this.sec - o.sec;
        }
    }
    
    static int[] dist;
    static List<List<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new Node(a, s));
            }

            dijkstra(c);
            int cnt = 0, max = 0;
            for (int i : dist) {
                if (i != Integer.MAX_VALUE) {
                    cnt++;
                    max = Math.max(max, i);
                }
            }

            bw.write(cnt + " " + max + "\n");
        }

        bw.close();
    }

    static void dijkstra(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(v, 0));
        dist[v] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.vertex] < cur.sec) {
                continue;
            }

            for (Node next : list.get(cur.vertex)) {
                int nextSec = cur.sec + next.sec;

                if (dist[next.vertex] > nextSec) {
                    dist[next.vertex] = nextSec;
                    pq.add(new Node(next.vertex, nextSec));
                }
            }
        }
    }
}
