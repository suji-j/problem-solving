import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger upFact = BigInteger.valueOf(1);
        for (int i = m + 1; i <= n; i++) {
            upFact = upFact.multiply(BigInteger.valueOf(i));
        }

        BigInteger downFact = BigInteger.valueOf(1);
        for (int i = 2; i <= n - m; i++) {
            downFact = downFact.multiply(BigInteger.valueOf(i));
        }

        bw.write(String.valueOf(upFact.divide(downFact)));
        bw.close();
    }
}
