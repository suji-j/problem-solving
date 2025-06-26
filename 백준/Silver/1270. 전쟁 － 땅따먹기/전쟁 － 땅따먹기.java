import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            HashMap<Long, Integer> map = new HashMap<>();

            for (int j = 0; j < t; j++) {
                if (!st.hasMoreTokens()) break;
                Long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.<Long, Integer>comparingByValue().reversed());

            if (list.get(0).getValue() > (t / 2)) {
                bw.write(list.get(0).getKey() + "\n");
            } else {
                bw.write("SYJKGW\n");
            }
        }

        bw.close();
    }
}
