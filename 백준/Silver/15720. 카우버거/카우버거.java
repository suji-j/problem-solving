import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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

        List<Integer> burger = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            burger.add(Integer.parseInt(st.nextToken()));
            set += burger.get(i);
        }

        List<Integer> side = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            side.add(Integer.parseInt(st.nextToken()));
            set += side.get(i);
        }

        List<Integer> drink = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            drink.add(Integer.parseInt(st.nextToken()));
            set += drink.get(i);
        }

        Collections.sort(burger, Collections.reverseOrder());
        Collections.sort(side, Collections.reverseOrder());
        Collections.sort(drink, Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < min; i++) {
            int sum = burger.get(i) + side.get(i) + drink.get(i);
            ans += sum * 0.9;
        }

        if (min < b) {
            for (int i = min; i < b; i++) {
                ans += burger.get(i);
            }
        }
        if (min < c) {
            for (int i = min; i < c; i++) {
                ans += side.get(i);
            }
        }
        if (min < d) {
            for (int i = min; i < d; i++) {
                ans += drink.get(i);
            }
        }

        bw.write(set + "\n");
        bw.write(String.valueOf(ans));
        bw.close();
    }
}
