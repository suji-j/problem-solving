import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int min = Math.min(Math.min(b, c), d);
        int set = 0;

        Integer[] burger = new Integer[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
            set += burger[i];
        }

        Integer[] side = new Integer[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            side[i] = Integer.parseInt(st.nextToken());
            set += side[i];
        }

        Integer[] drink = new Integer[d];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
            set += drink[i];
        }

        Arrays.sort(burger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < min; i++) {
            int sum = burger[i] + side[i] + drink[i];
            ans += sum * 0.9;
        }

        if (min < b) {
            for (int i = min; i < b; i++) {
                ans += burger[i];
            }
        }
        if (min < c) {
            for (int i = min; i < c; i++) {
                ans += side[i];
            }
        }
        if (min < d) {
            for (int i = min; i < d; i++) {
                ans += drink[i];
            }
        }

        bw.write(set + "\n");
        bw.write(String.valueOf(ans));
        bw.close();
    }
}
