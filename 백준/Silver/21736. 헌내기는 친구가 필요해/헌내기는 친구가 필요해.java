import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int y, x, person;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new char[y][x];
        visited = new boolean[y][x];

        int startY = 0, startX = 0;
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    startY = i;
                    startX = j;
                }
            }
        }

        dfs(startY, startX);
        System.out.println((person != 0) ? person : "TT");
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isVaild(moveY, moveX) && !visited[moveY][moveX]) {
                if (map[moveY][moveX] == 'O') {
                    dfs(moveY, moveX);
                } else if (map[moveY][moveX] == 'P') {
                    person++;
                    dfs(moveY, moveX);
                }
            }
        }
    }

    static boolean isVaild(int dy, int dx) {
        return dy >= 0 && dx >= 0 && dy < y && dx < x;
    }
}
