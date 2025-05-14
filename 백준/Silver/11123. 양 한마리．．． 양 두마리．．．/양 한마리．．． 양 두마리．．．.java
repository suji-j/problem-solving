import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int h, w, ans;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            visited = new boolean[h][w];

            for (int y = 0; y < h; y++) {
                String str = br.readLine();
                for (int x = 0; x < w; x++) {
                    arr[y][x] = str.charAt(x);
                }
            }

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (!visited[y][x] && arr[y][x] == '#') {
                        ans++;
                        dfs(y, x);
                    }
                }
            }

            bw.write(ans + "\n");
            ans = 0;
        }

        bw.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isValid(moveY, moveX) && !visited[moveY][moveX] && arr[moveY][moveX] == '#') {
                dfs(moveY, moveX);
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < h && moveX < w;
    }
}
