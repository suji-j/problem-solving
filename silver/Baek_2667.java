import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static int cnt = 0;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    static int[][] map;
    static ArrayList<Integer> cntList;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int allCnt = 0;
        visited = new boolean[n][n];
        cntList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt++;
                    cntList.add(dfs(i, j));
                    allCnt++;
                }
            }
        }

        System.out.println(allCnt);

        for (int i = cntList.size() - 1; i > 0; i--) {
            cntList.set(i, cntList.get(i) - cntList.get(i - 1));
        }
        Collections.sort(cntList);

        for (int i = 0; i < cntList.size(); i++) {
            System.out.println(cntList.get(i));
        }
    }

    static int dfs(int i, int j) {
        visited[i][j] = true;

        for (int count = 0; count < 4; count++) {
            int x = j + moveX[count];
            int y = i + moveY[count];

            if (0 <= x && 0 <= y && x < n && y < n && !visited[y][x] && map[y][x] == 1) {
                cnt++;
                dfs(y, x);
            }
        }
        return cnt;
    }
}