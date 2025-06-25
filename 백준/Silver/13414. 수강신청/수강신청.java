import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < l; i++) {
            String str = br.readLine();
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.remove(str);
                map.put(str, 1);
            }
        }

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (cnt == k) break;

            bw.write(entry.getKey() + "\n");
            cnt++;
        }
        bw.close();
    }
}
