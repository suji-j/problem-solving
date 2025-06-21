import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] trees = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees, Collections.reverseOrder());

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int growComplete = i + trees[i] + 1;
            maxDay = Math.max(maxDay, growComplete);
        }

        bw.write(String.valueOf(maxDay + 1));
        bw.close();
    }
}
