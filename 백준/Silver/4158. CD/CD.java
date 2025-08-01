import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (n != 0 && m != 0) {
            HashMap<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(br.readLine());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int cnt = 0;
            for (int key : map.keySet()) {
                if (map.get(key) == 2) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }
        bw.close();
    }
}
