import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set = new LinkedHashSet<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }

        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            back(0, i, n, arr);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int result = 1;
        for (int i : list) {
            if (result++ != i) {
                break;
            }
        }

        bw.write(String.valueOf(result > max ? result : --result));
        bw.close();
    }

    static void back(int start, int depth, int n, int[] arr) {
        if (result.size() == depth) {
            int sum = 0;
            for (int num : result) {
                sum += num;
            }
            set.add(sum);
            return;
        }

        for (int i = start; i < n; i++) {
            result.add(arr[i]);
            back(i + 1, depth, n, arr);
            result.remove(result.size() - 1);
        }
    }
}
