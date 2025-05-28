import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                int num = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                map.put(w, num);
            } else {
                int w = Integer.parseInt(st.nextToken());
                bw.write(map.get(w) + "\n");
            }
        }

        bw.close();
    }
}
