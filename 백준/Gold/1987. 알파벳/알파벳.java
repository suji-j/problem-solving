import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[][] alpha;
    static List<Character> contains;
    static boolean[][] visitied;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int r, c, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alpha = new char[r][c];
        visitied = new boolean[r][c];
        contains = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                alpha[i][j] = str.charAt(j);
            }
        }

        contains.add(alpha[0][0]);
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int y, int x, int cnt) {
        visitied[y][x] = true;
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (vaildYX(moveY, moveX) && !contains.contains(alpha[moveY][moveX]) && !visitied[moveY][moveX]) {
                contains.add(alpha[moveY][moveX]);
                dfs(moveY, moveX, cnt + 1);
            }
        }
        visitied[y][x] = false;
        contains.remove(contains.size() - 1);
    }

    static boolean vaildYX(int y, int x) {
        return (y >= 0 && x >= 0 && y < r && x < c);
    }
}
