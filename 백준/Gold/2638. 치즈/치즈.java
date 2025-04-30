import java.io.*;
import java.util.*;

public class Main {
    static int n, m, totalCheese;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    totalCheese++;
                }
            }
        }

        int time = 0;
        while (totalCheese > 0) {
            visited = new boolean[n][m];
            outSideAir(0, 0);

            meltCheese();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == -1) {
                        map[i][j] = 0;
                    }
                }
            }
            
            time++;
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }

    static void outSideAir(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        map[y][x] = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int moveY = cur[0] + dy[d];
                int moveX = cur[1] + dx[d];
                if (isValid(moveY, moveX) && !visited[moveY][moveX] && map[moveY][moveX] == 0) {
                    visited[moveY][moveX] = true;
                    map[moveY][moveX] = -1;
                    q.add(new int[]{moveY, moveX});
                }
            }
        }
    }

    static void meltCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int airContact = 0;
                    for (int d = 0; d < 4; d++) {
                        int moveY = i + dy[d];
                        int moveX = j + dx[d];

                        if (isValid(moveY, moveX) && map[moveY][moveX] == -1) {
                            airContact++;
                        }
                    }

                    if (airContact >= 2) {
                        map[i][j] = 0;
                        totalCheese--;
                    }
                }
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < n && moveX < m;
    }
}
