package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        int cnt = 0;

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            int aNumber = Integer.parseInt(st.nextToken());
            A.add(aNumber);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int bNumber = Integer.parseInt(st.nextToken());
            B.add(bNumber);
        }

        Set<Integer> copyA = new HashSet<>(A);

        A.removeAll(B);
        B.removeAll(copyA);

        System.out.println(A.size() + B.size());
    }
}
