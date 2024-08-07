import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = charArr[j];
            }
        }

        int redGreen = 0, notRedGreen = 0;
        boolean[][] rgVisited = new boolean[n][n];
        boolean[][] nrgVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rgVisited[i][j]) {
                    redGreen(i, j, rgVisited);
                    redGreen += 1;
                }

                if (!nrgVisited[i][j]) {
                    notRedGreen(i, j, nrgVisited);
                    notRedGreen += 1;
                }
            }
        }

        System.out.println(notRedGreen + " " + redGreen);
    }

    public static void redGreen(int y, int x, boolean[][] rgVisited) {
        rgVisited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            char ch = map[y][x];
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isVaild(moveY, moveX) && !rgVisited[moveY][moveX]) {
                if ((ch == 'R' || ch == 'G') && (map[moveY][moveX] == 'R' || map[moveY][moveX] == 'G')) {
                    redGreen(moveY, moveX, rgVisited);
                } else if (ch == 'B' && map[moveY][moveX] == 'B') {
                    redGreen(moveY, moveX, rgVisited);
                }
            }
        }
    }

    public static void notRedGreen(int y, int x, boolean[][] nrgVisited) {
        nrgVisited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            char ch = map[y][x];
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isVaild(moveY, moveX) && !nrgVisited[moveY][moveX]) {
                if (ch == map[moveY][moveX]) {
                    notRedGreen(moveY, moveX, nrgVisited);
                }
            }
        }
    }

    public static boolean isVaild(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
