import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        int cnt = 0;
        String name = "";
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                String algo = st.nextToken();
                map.put(algo, map.getOrDefault(algo, 0) + 1);

                if (cnt < map.get(algo)) {
                    cnt = map.get(algo);
                    name = algo;
                }
            }
        }

        boolean flag = false;
        for (String key : map.keySet()) {
            if (cnt == map.get(key) && !key.equals(name)) {
                flag = true;
                break;
            }
        }

        bw.write(flag ? "-1" : name);
        bw.close();
    }
}
