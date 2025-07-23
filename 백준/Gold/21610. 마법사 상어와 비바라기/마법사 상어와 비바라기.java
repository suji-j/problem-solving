import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int[][] arr;
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n - 1, 0));
        q.add(new Node(n - 1, 1));
        q.add(new Node(n - 2, 0));
        q.add(new Node(n - 2, 1));
        HashSet<String> set = new HashSet<>();

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            while (!q.isEmpty()) {
                Node cur = q.poll();
                int nextY = (cur.y + ((dy[d] * s) % n) + n) % n;
                int nextX = (cur.x + ((dx[d] * s) % n) + n) % n;
                arr[nextY][nextX] += 1;
                set.add(nextY + " " + nextX);
            }

            for (String str : set) {
                String[] strArr = str.split(" ");
                int[] cur = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    cur[i] = Integer.parseInt(strArr[i]);
                }

                arr[cur[0]][cur[1]] += checkWater(cur[0], cur[1]);
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (arr[y][x] >= 2 && !set.contains(y + " " + x)) {
                        arr[y][x] -= 2;
                        q.add(new Node(y, x));
                    }
                }
            }
            set.clear();
        }

        int result = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result += arr[y][x];
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }

    static int checkWater(int y, int x) {
        int cnt = 0;

        if (y > 0 && x > 0 && arr[y - 1][x - 1] > 0) {
            cnt++;
        }
        if (y > 0 && x < n - 1 && arr[y - 1][x + 1] > 0) {
            cnt++;
        }
        if (y < n - 1 && x > 0 && arr[y + 1][x - 1] > 0) {
            cnt++;
        }
        if (y < n - 1 && x < n - 1 && arr[y + 1][x + 1] > 0) {
            cnt++;
        }

        return cnt;
    }
}
