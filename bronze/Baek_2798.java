package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min;
        int result = 0;

        int[] card = new int[N];
        List<Integer> sum = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = card[i] + card[j] + card[k];
                    if (temp > M) {
                        continue;
                    }
                    sum.add(temp);
                }
            }
        }

        Collections.sort(sum);
        min = Math.abs(M - sum.get(0));

        for (int i = 1; i < sum.size(); i++) {
            if (Math.abs(M - sum.get(i)) < min) {
                min = Math.abs(M - sum.get(i));
                result = i;
            }
        }
        //12 11 9 7
        System.out.println(sum.get(result));
    }
}
