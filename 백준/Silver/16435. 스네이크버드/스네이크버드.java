import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] fruit = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(fruit);

        for (int i : fruit) {
            if (i <= l) {
                l += 1;
            }
        }

        bw.write(String.valueOf(l));
        bw.close();
    }
}
