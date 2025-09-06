import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparator<Node> {
        int place, cost;

        public Node(int place, int cost) {
            this.place = place;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.place - o2.place;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
            map[i][0] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;
        }

        int peopleCnt = Integer.parseInt(br.readLine());
        int[] people = new int[peopleCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < peopleCnt; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        List<Node> result = new ArrayList<>();
        int point = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < peopleCnt; j++) {
                max = Math.max(max, map[i][people[j]] + map[people[j]][i]);
            }

            if (min > max) {
                result = new ArrayList<>();
                min = max;
                point = i;
                result.add(new Node(point, min));
            } else if (min == max) {
                result.add(new Node(i, min));
            }
        }

        if (result.size() > 1) {
            for (Node cur : result) {
                bw.write(cur.place + " ");
            }
        } else {
            bw.write(String.valueOf(point));
        }
        bw.close();
    }
}
