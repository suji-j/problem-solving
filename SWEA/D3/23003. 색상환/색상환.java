import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("red", 1);
        map.put("orange", 2);
        map.put("yellow", 3);
        map.put("green", 4);
        map.put("blue", 5);
        map.put("purple", 6);

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = map.get(st.nextToken());
            int v2 = map.get(st.nextToken());
            int diff = Math.abs(v1 - v2);
            if (diff == 0) {
                bw.write("E\n");
            } else if (diff == 1 || diff == 5) {
                bw.write("A\n");
            } else if (diff == 3) {
                bw.write("C\n");
            } else {
                bw.write("X\n");
            }
        }
        bw.close();
    }
}
