import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static HashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        back(0);
        for (String str : set) {
            bw.write(str + "\n");
        }
        bw.close();
    }

    static void back(int depth) throws IOException {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                back(depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
