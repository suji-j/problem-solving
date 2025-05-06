import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int r, c, curWolf, curSheep;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        int totalWolf = 0, totalSheep = 0;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'v') {
                    totalWolf++;
                } else if (map[i][j] == 'k') {
                    totalSheep++;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    if (map[i][j] == 'v') {
                        curWolf++;
                    } else if (map[i][j] == 'k') {
                        curSheep++;
                    }

                    dfs(i, j);

                    if (curSheep > curWolf) {
                        totalWolf -= curWolf;
                    } else {
                        totalSheep -= curSheep;
                    }

                    curWolf = 0;
                    curSheep = 0;
                }
            }
        }

        bw.write(totalSheep + " " + totalWolf);
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isValid(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] != '#') {
                if (map[nextY][nextX] == 'v') {
                    curWolf++;
                } else if (map[nextY][nextX] == 'k') {
                    curSheep++;
                }

                dfs(nextY, nextX);
            }
        }
    }

    static boolean isValid(int nextY, int nextX) {
        return nextY >= 0 && nextX >= 0 && nextY < r && nextX < c;
    }
}
