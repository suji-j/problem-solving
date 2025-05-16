import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static char[][] arr;
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
    static Map<String, Integer> map = new HashMap<>();
    static String answer;
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
            answer = br.readLine();

            if (map.containsKey(answer)) {
                bw.write(map.get(answer) + "\n");
                continue;
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    sb = new StringBuilder();
                    sb.append(arr[y][x]);
                    
                    if (answer.startsWith(sb.toString())) {
                        dfs(y, x, answer.length());
                        map.put(answer, cnt);
                    }
                }
            }
            bw.write(cnt + "\n");
            cnt = 0;
        }
        bw.close();
    }

    static void dfs(int y, int x, int maxDepth) {
        String cur = sb.toString();

        if (cur.length() > maxDepth) return;

        if (answer.equals(cur)) {
            cnt++;
        }

        boolean flag = !answer.startsWith(cur);
        if (flag) return;

        for (int i = 0; i < 8; i++) {
            int moveY = (y + dy[i] + n) % n;
            int moveX = (x + dx[i] + m) % m;

            sb.append(arr[moveY][moveX]);
            dfs(moveY, moveX, maxDepth);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
