import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int totalWolf, totalSheep;
    static int curWolf, curSheep;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[r][c];
        visited = new boolean[r][c];

        for (int y = 0; y < r; y++) {
            String[] str = br.readLine().split("");
            for (int x = 0; x < c; x++) {
                arr[y][x] = str[x];

                if (arr[y][x].equals("v")) {
                    totalWolf++;
                } else if (arr[y][x].equals("o")) {
                    totalSheep++;
                }
            }
        }

        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (!arr[y][x].equals("#") && !visited[y][x]) {
                    dfs(y, x);

                    if (curSheep != 0 && curWolf != 0) {
                        if (curSheep > curWolf) {
                            totalWolf -= curWolf;
                        } else {
                            totalSheep -= curSheep;
                        }
                    }

                    curWolf = 0;
                    curSheep = 0;
                }
            }
        }

        bw.write(totalSheep + " " + totalWolf);
        bw.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        if (arr[y][x].equals("o")) {
            curSheep++;
        } else if (arr[y][x].equals("v")) {
            curWolf++;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isValid(nextY, nextX) && !visited[nextY][nextX] && !arr[nextY][nextX].equals("#")) {
                dfs(nextY, nextX);
            }
        }
    }

    static boolean isValid(int nextY, int nextX) {
        return nextY >= 0 && nextX >= 0 && nextY < r && nextX < c;
    }
}
