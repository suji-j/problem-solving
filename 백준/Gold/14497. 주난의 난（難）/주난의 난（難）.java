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

    static int n, m;
    static int x1, x2, y1, y2;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1][m + 1];
        map = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        bw.write(String.valueOf(bfs(y1, x1)));
        bw.close();
    }

    static int bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        Queue<Node> nextQ = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;
        int jump = 0;

        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int moveY = cur.y + dy[i];
                    int moveX = cur.x + dx[i];

                    if (isValid(moveY, moveX) && !visited[moveY][moveX]) {
                        if (map[moveY][moveX] == '#') {
                            return jump + 1;
                        }
                        visited[moveY][moveX] = true;

                        if (map[moveY][moveX] == '1') {
                            nextQ.add(new Node(moveY, moveX));
                        } else {
                            q.add(new Node(moveY, moveX));
                        }
                    }
                }
            }
            q = nextQ;
            nextQ = new LinkedList<>();
            jump++;
        }

        return 0;
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 1 && moveX >= 1 && moveY <= n && moveX <= m;
    }
}
