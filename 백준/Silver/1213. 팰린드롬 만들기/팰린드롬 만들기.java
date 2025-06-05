import java.io.*;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] cur = br.readLine().toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (char c : cur) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int odd = 0;
        char midChar = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                odd++;
                midChar = c;
            }
        }

        if (odd >= 2) {
            bw.write("I'm Sorry Hansoo");
        } else {
            StringBuilder half = new StringBuilder();

            for (char c : map.keySet()) {
                int count = map.get(c) / 2;
                for (int i = 0; i < count; i++) {
                    half.append(c);
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(half);
            if (odd == 1) result.append(midChar);
            result.append(half.reverse());
            bw.write(result.toString());
        }

        bw.close();
    }
}
