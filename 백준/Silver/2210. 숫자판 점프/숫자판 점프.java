import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static HashSet<String> set = new HashSet<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new String[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, map[i][j]);
            }
        }

        bw.write(set.size() + "");
        bw.close();
    }

    static void dfs(int y, int x, int cnt, String str) {
        if (cnt == 5) {
            set.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isVaild(moveY, moveX)) {
                dfs(moveY, moveX, cnt + 1, str + map[moveY][moveX]);
            }
        }
    }

    static boolean isVaild(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < 5 && moveX < 5;
    }
}
