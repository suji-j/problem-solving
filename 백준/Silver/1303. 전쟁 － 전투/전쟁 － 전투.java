import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static char[][] map;
    static boolean[][] visited;
    static Map<Character, Integer> cnt = new HashMap<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        visited = new boolean[m][n];

        for (int y = 0; y < m; y++) {
            String str = br.readLine();
            for (int x = 0; x < n; x++) {
                map[y][x] = str.charAt(x);
            }
        }
        cnt.put('W', 0);
        cnt.put('B', 0);

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x]) {
                    result = 1;
                    char curC = map[y][x];
                    dfs(y, x, map[y][x]);
                    int sum = (int) Math.pow(result, 2);

                    if (map[y][x] == 'W') {
                        cnt.put(curC, cnt.get(curC) + sum);
                    } else {
                        cnt.put(curC, cnt.get(curC) + sum);
                    }
                }
            }
        }

        bw.write(cnt.get('W') + " " + cnt.get('B'));
        bw.close();
    }

    static void dfs(int y, int x, char c) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isValid(moveY, moveX) && !visited[moveY][moveX] && map[moveY][moveX] == c) {
                result += 1;
                dfs(moveY, moveX, c);
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < m && moveX < n;
    }
}
