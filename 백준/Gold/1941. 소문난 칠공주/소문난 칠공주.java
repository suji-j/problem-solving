import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int ans = 0;
    static List<int[]> result = new ArrayList<>();
    static Character[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new Character[5][5];
        visited = new boolean[5][5];

        for (int y = 0; y < 5; y++) {
            String str = br.readLine();
            for (int x = 0; x < 5; x++) {
                arr[y][x] = str.charAt(x);
            }
        }

        back(0, 0, 0, 0);

        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void back(int y, int x, int depth, int sCnt) {
        if (depth == 7) {
            if (sCnt >= 4) {
                if (bfs()) {
                    ans++;
                }
            }
            return;
        }

        for (int i = y; i < 5; i++) {
            for (int j = (i == y) ? x : 0; j < 5; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    result.add(new int[]{i, j});
                    back(i, j, depth + 1, arr[i][j] == 'S' ? sCnt + 1 : sCnt);
                    visited[i][j] = false;
                    result.remove(result.size() - 1);
                }
            }
        }
    }

    static boolean bfs() {
        boolean[][] visitedBfs = new boolean[5][5];
        Queue<Node> q = new LinkedList<>();

        int[] current = result.get(0);
        q.add(new Node(current[0], current[1]));
        visitedBfs[current[0]][current[1]] = true;

        int cnt = 1;
        Set<String> set = new HashSet<>();
        for (int[] curNode : result) {
            set.add(curNode[0] + " " + curNode[1]);
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = cur.y + dy[i];
                int moveX = cur.x + dx[i];

                if (isVaild(moveY, moveX) && !visitedBfs[moveY][moveX] && set.contains(moveY + " " + moveX)) {
                    q.add(new Node(moveY, moveX));
                    visitedBfs[moveY][moveX] = true;
                    cnt++;
                }
            }
        }

        return cnt == 7;
    }

    static boolean isVaild(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < 5 && moveX < 5;
    }
}
