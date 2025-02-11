import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int y, x;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1 , 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0, preCheese = 0;
        while (true) {
            visit = new boolean[y][x];
            int cheeseCnt = cheese();
            if (cheeseCnt == 0) break;

            preCheese = cheeseCnt;
            melt();
            time++;
        }

        System.out.println(time);
        System.out.println(preCheese);
    }

    static int cheese() {
        int cnt = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    static void melt() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cy = now[0], cx = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (vaildMap(ny, nx) && !visit[ny][nx]) {
                    visit[ny][nx] = true;

                    if (map[ny][nx] == 0) {
                        q.add(new int[]{ny, nx});
                    } else if (map[ny][nx] == 1) {
                        map[ny][nx] = 0;
                    }
                }
            }
        }


    }

    static boolean vaildMap(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < y && nx < x;
    }
}