import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String cur = br.readLine();

        Map<Character, Integer> baseMap = new HashMap<>();
        for (int i = 0; i < cur.length(); i++) {
            baseMap.put(cur.charAt(i), baseMap.getOrDefault(cur.charAt(i), 0) + 1);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            String next = br.readLine();

            Map<Character, Integer> targetMap = new HashMap<>();
            for (int j = 0; j < next.length(); j++) {
                targetMap.put(next.charAt(j), targetMap.getOrDefault(next.charAt(j), 0) + 1);
            }

            HashSet<Character> set = new HashSet<>();
            set.addAll(baseMap.keySet());
            set.addAll(targetMap.keySet());

            int diff = 0;
            for (char ch : set) {
                int cnt1 = baseMap.getOrDefault(ch, 0);
                int cnt2 = targetMap.getOrDefault(ch, 0);
                diff += Math.abs(cnt1 - cnt2);
            }

            if (diff == 0 || diff == 1 || (diff == 2 && cur.length() == next.length())) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
