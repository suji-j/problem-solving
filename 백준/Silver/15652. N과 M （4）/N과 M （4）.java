import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] num;
    static List<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }

        back(0, 0);
        bw.write(sb.toString());
        bw.close();
    }

    static void back(int start, int depth) {
        if (depth == m) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            result.add(num[i]);
            back(i, depth + 1);
            result.remove(result.size() - 1);
        }
    }
}
