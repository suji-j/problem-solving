import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }

        for (int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(",");

            for (int j = 0; j < arr.length; j++) {
                map.remove(arr[j]);
            }

            bw.write(map.size() + "\n");
        }
        bw.close();
    }
}
