import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();
    static Set<String> ans = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        back(0);

        bw.write(String.valueOf(ans.size()));
        bw.close();
    }

    static void back(int depth) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i);
            }
            ans.add(sb.toString());
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(arr[i]);
                back(depth + 1);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
}
