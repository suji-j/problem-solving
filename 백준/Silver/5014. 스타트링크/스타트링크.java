import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f + 1];
        bw.write(bfs(s, 0) ? "use the stairs" : String.valueOf(result));
        bw.close();
    }

    static boolean bfs(int cur, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cur, cnt});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int floor = current[0];
            int count = current[1];

            if (floor == g) {
                result = count;
                return false;
            }

            if (floor + u <= f && !visited[floor + u]) {
                int next = floor + u;
                q.add(new int[]{next, count + 1});
                visited[next] = true;
            }

            if (floor - d > 0 && !visited[floor - d]) {
                int next = floor - d;
                q.add(new int[]{next, count + 1});
                visited[next] = true;
            }
        }

        return true;
    }
}
