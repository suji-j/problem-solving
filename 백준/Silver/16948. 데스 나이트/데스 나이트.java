import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int n;
    static int min = Integer.MAX_VALUE;
    static int r1, c1, r2, c2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1);
        bw.write(String.valueOf(min == Integer.MAX_VALUE ? -1 : min));
        bw.close();
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, 0));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curCnt = cur.cnt;

            if (curR == r2 && curC == c2) {
                min = Math.min(min, curCnt);
            }

            for (int i = 0; i < 6; i++) {
                int moveR = curR + dy[i];
                int moveC = curC + dx[i];

                if (isValid(moveR, moveC) && !visited[moveR][moveC]) {
                    visited[moveR][moveC] = true;
                    q.add(new Node(moveR, moveC, curCnt + 1));
                }
            }
        }
    }

    static boolean isValid(int moveR, int moveC) {
        return moveR >= 0 && moveC >= 0 && moveR < n && moveC < n;
    }
}
