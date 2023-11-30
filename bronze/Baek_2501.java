package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> divisor = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int num;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisor.add(i);
            }
        }

        try {
            num = divisor.get(K - 1);
        } catch (IndexOutOfBoundsException e) {
            num = 0;
        }
        System.out.println(num);
    }
}
