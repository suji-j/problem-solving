import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static boolean[][] visit;
    public static Queue<int[]> queue;
    public static int cnt, l;
    public static int[] dx = {-2, 2, -2, 2, -1, 1, -1, 1};
    public static int[] dy = {1, 1, -1, -1, 2, 2, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visit = new boolean[l][l];
            queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());
            visit[nowY][nowX] = true;

            st = new StringTokenizer(br.readLine());
            int goX = Integer.parseInt(st.nextToken());
            int goY = Integer.parseInt(st.nextToken());

            bfs(nowY, nowX, goY, goX);

            bw.write(cnt + "\n");
            cnt = 0;
        }
        bw.close();
        br.close();
    }

    static int bfs(int nowY, int nowX, int goY, int goX) {
        visit[nowY][nowX] = true;
        queue.add(new int[]{nowY, nowX});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            ;
            int nodeY = arr[0];
            int nodeX = arr[1];

            cnt = map[nodeY][nodeX];
            if (nodeY == goY && nodeX == goX) {
                return cnt;
            } else {
                for (int i = 0; i < 8; i++) {
                    int y = nodeY + dy[i];
                    int x = nodeX + dx[i];

                    if (0 <= y && y < l && 0 <= x && x < l) {
                        if (!visit[y][x]) {
                            visit[y][x] = true;
                            map[y][x] = cnt + 1;
                            queue.add(new int[]{y, x});
                        }
                    }
                }
            }
        }

        return 0;
    }
}