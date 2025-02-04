import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n + 1];
        prime[1] = true;

        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                result++;
                for (int j = i * i; j <= n; j += i) {
                    if (!prime[j]) {
                        prime[j] = true;
                        result++;
                    }

                    if (result == k) {
                        System.out.println(j);
                        return;
                    }
                }
            }
            if (result == k) {
                System.out.println(i);
                return;
            }
        }
        bw.close();
        br.close();
    }
}
