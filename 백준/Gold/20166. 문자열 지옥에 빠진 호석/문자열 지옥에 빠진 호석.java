import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    static int n, m, maxDepth;
    static char[][] arr;
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
    static HashMap<String, Integer> map = new LinkedHashMap<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < k; i++) {
            String str = br.readLine();
            map.put(str, 0);
            maxDepth = Math.max(maxDepth, str.length());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb = new StringBuilder();
                sb.append(arr[i][j]);
                dfs(i, j);
            }
        }

        for (String str : map.keySet()) {
            bw.write(map.get(str) + "\n");
        }
        bw.close();
    }

    static void dfs(int y, int x) {
        String cur = sb.toString();
        if (map.containsKey(cur)) {
            map.put(cur, map.get(cur) + 1);
            return;
        }

        if (cur.length() >= maxDepth) return;

        boolean flag = true;
        for (String str : map.keySet()) {
            if (str.startsWith(cur)) {
                flag = false;
                break;
            }
        }
        if (flag) return;

        for (int i = 0; i < 8; i++) {
            int moveY = (y + dy[i] + n) % n;
            int moveX = (x + dx[i] + m) % m;

            sb.append(arr[moveY][moveX]);
            dfs(moveY, moveX);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
