import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int cnt = 0; cnt < t; cnt++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int max = -Integer.MAX_VALUE;
            int currentSum = 0;

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                currentSum += num;
                max = Math.max(max, currentSum);

                if (currentSum < 0) {
                    currentSum = 0;
                }
            }

            bw.write(max + "\n");
        }

        bw.close();
    }
}
