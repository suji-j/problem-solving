import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0L;
        long mod = 1234567891;
        long r = 1;
        for (int i = 0; i < l; i++) {
            long temp = (long) (str.charAt(i) - 96) * r;
            sum += temp % mod;
            r = (r * 31) % mod;
        }

        System.out.println(sum % mod);
    }
}