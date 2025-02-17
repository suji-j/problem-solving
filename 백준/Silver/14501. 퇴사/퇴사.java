import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] work;
    static int n, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        work = new int[n + 1][2];
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }

        back(1, 0);
        System.out.println(max);
    }

    static void back(int day, int price) {
        if (day > n) {
            max = Math.max(max, price);
            return;
        }

        if (day + work[day][0] <= n + 1) {
            back(day + work[day][0], price + work[day][1]);
        }

        back(day + 1, price);
    }
}
