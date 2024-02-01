import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();

            map.put(key, value);
        }

        for (int i = 0; i < m; i++) {
            String search = br.readLine();
            bw.write(map.get(search));
            bw.write("\n");
        }

        bw.flush();
    }
}