import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> preA = new ArrayList<>();
        preSum(n, preA, a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> preB = new ArrayList<>();
        preSum(m, preB, b);
        HashMap<Integer, Integer> subB = new HashMap<>();
        for (int i : preB) {
            subB.put(i, subB.getOrDefault(i, 0) + 1);
        }

        long ans = 0;
        for (int i : preA) {
            int sum = t - i;
            ans += subB.getOrDefault(sum, 0);
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void preSum(int n, List<Integer> list, int[] arr) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }

}
