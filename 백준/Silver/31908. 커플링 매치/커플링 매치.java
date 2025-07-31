import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();

            if (!ring.equals("-")) {
                map.put(ring, map.getOrDefault(ring, new StringBuilder("")).append(name).append(" "));
            }
        }

        int cnt = 0;
        List<String> list = new ArrayList<>();
        for (String ring : map.keySet()) {
            StringBuilder sb = map.get(ring);
            String[] arr = sb.toString().split(" ");

            if (arr.length == 2) {
                cnt++;
                list.add(sb.toString());
            }
        }

        bw.write(cnt + "\n");
        for (String str : list) {
            bw.write(str + "\n");
        }
        bw.close();
    }
}
