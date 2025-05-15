import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, l, r, sum;
    static int[][] arr;
    static boolean[][] visited;
    static List<Node> list;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        list = new ArrayList<>();
                        sum = 0;
                        bfs(i, j);

                        if (list.size() > 1) {
                            int result = sum / list.size();
                            for (Node cur : list) {
                                arr[cur.y][cur.x] = result;
                            }
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) {
                break;
            }
            ans++;
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;
        list.add(new Node(y, x));
        sum = arr[y][x];

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = cur.y + dy[i];
                int moveX = cur.x + dx[i];

                if (isValid(moveY, moveX) && !visited[moveY][moveX]) {
                    int gap = Math.abs(arr[cur.y][cur.x] - arr[moveY][moveX]);
                    if (gap >= l && gap <= r) {
                        sum += arr[moveY][moveX];
                        list.add(new Node(moveY, moveX));
                        visited[moveY][moveX] = true;
                        q.add(new Node(moveY, moveX));
                    }
                }
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < n && moveX < n;
    }
}
