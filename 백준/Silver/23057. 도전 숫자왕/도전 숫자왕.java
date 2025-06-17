import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static List<Integer> result = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        for (int i = 1; i <= n; i++) {
            back(0, i);
        }

        bw.write(String.valueOf(sum - set.size()));
        bw.close();
    }

    static void back(int start, int depth) {
        if (result.size() == depth) {
            int sum = 0;
            for (int i : result) {
                sum += i;
            }
            set.add(sum);
            return;
        }

        for (int i = start; i < n; i++) {
            result.add(arr[i]);
            back(i + 1, depth);
            result.remove(result.size() - 1);
        }
    }
}
