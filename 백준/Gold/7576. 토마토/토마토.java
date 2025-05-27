import java.io.*;
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

    static int m, n, ans = 1;
    static int[][] arr;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Node> tomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findRipe();
        bfs();

        bw.write(String.valueOf(findUnripe() == 0 ? ans - 1 : -1));
        bw.close();
    }

    static int findUnripe() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void findRipe() {
        tomato = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    tomato.add(new Node(i, j));
                }
            }
        }
    }

    static void bfs() {
        while (!tomato.isEmpty()) {
            Node cur = tomato.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = cur.y + dy[i];
                int moveX = cur.x + dx[i];

                if (isValid(moveY, moveX) && arr[moveY][moveX] != -1) {
                    if (arr[moveY][moveX] == 0) {
                        arr[moveY][moveX] = arr[cur.y][cur.x] + 1;
                        tomato.add(new Node(moveY, moveX));
                    } else {
                        arr[moveY][moveX] = Math.min(arr[moveY][moveX], arr[cur.y][cur.x] + 1);
                    }
                    ans = Math.max(ans, arr[moveY][moveX]);
                }
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 & moveY < n && moveX < m;
    }
}
