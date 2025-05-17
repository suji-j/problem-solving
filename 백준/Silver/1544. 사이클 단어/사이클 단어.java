import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            String min = getType(word);
            set.add(min);
        }

        bw.write(String.valueOf(set.size()));
        bw.close();
    }

    static String getType(String word) {
        String min = word;

        for (int i = 1; i < word.length(); i++) {
            String rotated = word.substring(i) + word.substring(0, i);
            if (rotated.compareTo(min) < 0) {
                min = rotated;
            }
        }

        return min;
    }
}
