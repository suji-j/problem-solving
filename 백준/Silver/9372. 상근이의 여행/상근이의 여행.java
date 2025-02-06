import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] parent = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b, parent);
            }

            System.out.println(result);
        }
    }

    static int find(int num, int[] parent) {
        if (num == parent[num]) {
            return num;
        } else {
            return parent[num] = find(parent[num], parent);
        }
    }

    static void union(int n1, int n2, int[] parent) {
        n1 = find(n1, parent);
        n2 = find(n2, parent);

        if (n1 != n2) {
            if (n1 < n2) {
                parent[n2] = n1;
            } else {
                parent[n1] = n2;
            }
            result++;
        }
    }
}
