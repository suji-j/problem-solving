import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> lan = new ArrayList<>();

        long end = 0;
        for (int i = 0; i < k; i++) {
            lan.add(Integer.parseInt(br.readLine()));
            if (end < lan.get(i)) {
                end = lan.get(i);
            }
        }
        end++;

        long start = 1;
        while (start < end) {
            long result = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < k; i++) {
                result += (long) lan.get(i) / mid;
            }

            if (result < n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start - 1);
    }
}