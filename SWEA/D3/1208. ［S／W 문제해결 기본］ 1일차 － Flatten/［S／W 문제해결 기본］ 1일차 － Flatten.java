import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < n; j++) {
                Collections.sort(list);
                list.add(list.remove(list.size() - 1) - 1);
                list.add(list.remove(0) + 1);
            }

            Collections.sort(list);
            bw.write("#" + (i + 1) + " " + (list.get(list.size() - 1) - list.get(0)) + "\n");
        }
        bw.close();
    }
}
