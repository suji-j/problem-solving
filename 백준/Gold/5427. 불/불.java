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

    static int w, h, minDist;
    static char[][] arr;
    static int[][] fireDist;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            int sgY = 0, sgX = 0;

            for (int y = 0; y < h; y++) {
                String str = br.readLine();
                for (int x = 0; x < w; x++) {
                    arr[y][x] = str.charAt(x);
                    if (arr[y][x] == '@') {
                        sgY = y;
                        sgX = x;
                    }
                }
            }

            fire();
            escape(sgY, sgX);

            if (minDist == Integer.MAX_VALUE) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(minDist + 1 + "\n");
            }
        }
        bw.close();
    }

    static void fire() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        fireDist = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(fireDist[i], Integer.MAX_VALUE);
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (arr[y][x] == '*') {
                    q.add(new Node(y, x));
                    fireDist[y][x] = 0;
                    visited[y][x] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (!isValid(ny, nx)) continue;
                if (arr[ny][nx] == '#') continue;
                if (visited[ny][nx]) continue;

                fireDist[ny][nx] = Math.min(fireDist[ny][nx], fireDist[cur.y][cur.x] + 1);
                q.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }
    }

    static void escape(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));

        boolean[][] visited = new boolean[h][w];
        visited[y][x] = true;

        int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[y][x] = 0;
        minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (!isValid(ny, nx)) {
                    if (dist[cur.y][cur.x] < fireDist[cur.y][cur.x]) {
                        minDist = Math.min(minDist, dist[cur.y][cur.x]);
                    }
                    continue;
                }
                if (visited[ny][nx]) continue;

                if (arr[ny][nx] != '#' && dist[cur.y][cur.x] + 1 < fireDist[ny][nx]) {
                    dist[ny][nx] = dist[cur.y][cur.x] + 1;
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx));
                }
            }
        }
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < h && x < w;
    }
}
