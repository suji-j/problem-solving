import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean flag = false;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Node> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        result.add(new Node(r, c));
        visited[r][c] = true;

        back(r, c);
        bw.write(flag ? "1" : "0");
        bw.close();
    }

    static void back(int y, int x) {
        if (flag) {
            return;
        }

        if (result.size() == 4) {
            int apple = 0;
            for (Node cur : result) {
                if (arr[cur.y][cur.x] == 1) {
                    apple += 1;
                }
            }

            if (apple >= 2) {
                flag = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];
            boolean wall = false;

            if (isValid(moveY, moveX) && arr[moveY][moveX] != -1 && !visited[moveY][moveX]) {
                if (arr[moveY][moveX] == 0) {
                    arr[moveY][moveX] = -1;
                    wall = true;
                }

                visited[moveY][moveX] = true;
                result.add(new Node(moveY, moveX));
                back(moveY, moveX);
                result.remove(result.size() - 1);
                visited[moveY][moveX] = false;

                if (wall) {
                    arr[moveY][moveX] = 0;
                }
            }
        }
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < 5 && x < 5;
    }
}
