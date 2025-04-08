import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static List<Integer> result = new ArrayList<>();
    static Set<String> ans = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        back(0);
        for (String str : ans) {
            bw.write(str + "\n");
        }
        bw.close();
    }

    static void back(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr[i]);
            back(depth + 1);
            result.remove(result.size() - 1);
        }
    }
}
