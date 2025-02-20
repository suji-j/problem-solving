import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int y, x, max;
    static char[][] map;
    static int[][] dis;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new char[y][x];
        dis = new int[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'W') {
                    dis[i][j] = -1;
                } else {
                    dis[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
                resetVisited();
                resetDis();
            }
        }

        System.out.println(max);
    }

    static void bfs(int y, int x) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int Y = point[0];
            int X = point[1];

            for (int i = 0; i < 4; i++) {
                int moveY = Y + dy[i];
                int moveX = X + dx[i];

                if (isVaild(moveY, moveX) && !visited[moveY][moveX] && map[moveY][moveX] == 'L') {
                    visited[moveY][moveX] = true;
                    dis[moveY][moveX] = dis[Y][X] + 1;
                    if (max < dis[moveY][moveX]) {
                        max = dis[moveY][moveX];
                    }
                    q.add(new int[]{moveY, moveX});
                }
            }
        }
    }

    static boolean isVaild(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < y && moveX < x;
    }

    static void resetVisited() {
        for (int i = 0; i < y; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static void resetDis() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (dis[i][j] != -1) {
                    dis[i][j] = 0;
                }
            }
        }
    }
}
