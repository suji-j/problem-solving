import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] credit;
    static List<List<Integer>> boss = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            boss.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int staff = Integer.parseInt(st.nextToken());
            if (staff == -1) continue;
            boss.get(staff).add(i);
        }

        credit = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int staff = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            credit[staff] += w;
        }

        dfs(1, credit[1]);

        for (int i = 1; i <= n; i++) {
            bw.write(credit[i] + " ");
        }
        bw.close();
    }

    static void dfs(int curStaff, int w) {
        for (int nextStaff : boss.get(curStaff)) {
            credit[nextStaff] += credit[curStaff];
            dfs(nextStaff, w);
        }
    }
}
