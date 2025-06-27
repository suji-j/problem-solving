import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] pre, cur;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        pre = new char[r][c]; // 이전 폭탄
        cur = new char[r][c]; // 현재 폭탄
//        next = new char[r][c]; // 다음 폭탄

        int time = 1;
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                cur[i][j] = str.charAt(j);
            }
        }

        if (n == 1) { // 1초하면 초기 상태를 그대로 반환
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(cur[i][j]);
                }
                bw.write("\n");
            }
        } else {
            while (time < n) {
                time++;
                if (time % 2 == 0) {
                    for (int i = 0; i < r; i++) {
                        pre[i] = Arrays.copyOf(cur[i], c);
                    }
                    allBomb();
                } else {
                    visited = new boolean[r][c];
                    explosion();
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(cur[i][j]);
                }
                bw.write("\n");
            }
        }
        bw.close();
    }

    static void allBomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cur[i][j] = 'O';
            }
        }
    }

    static void explosion() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pre[i][j] == 'O') {
                    cur[i][j] = '.';
                    for (int idx = 0; idx < 4; idx++) {
                        int nextY = i + dy[idx];
                        int nextX = j + dx[idx];

                        if (isValid(nextY, nextX) && !visited[nextY][nextX] && cur[nextY][nextX] == 'O') {
                            visited[nextY][nextX] = true;
                            cur[nextY][nextX] = '.';
                        }
                    }
                }
            }
        }
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < r && x < c;
    }
}
