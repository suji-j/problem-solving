import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        map.put("ChongChong", 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            int p1Cnt = map.getOrDefault(p1, 0);
            int p2Cnt = map.getOrDefault(p2, 0);
            if (p1Cnt == 0 && p2Cnt == 0) {
                map.put(p1, 0);
                map.put(p2, 0);
            } else {
                if (p1Cnt >= 1 && p2Cnt >= 1) {
                    continue;
                }
                map.put(p1, map.getOrDefault(p1, 0) + 1);
                map.put(p2, map.getOrDefault(p2, 0) + 1);
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
