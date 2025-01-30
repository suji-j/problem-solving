import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int one = 0, zero = 0;
        char prev = str.charAt(0);
        if (prev == '0') {
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != prev) {
                if (str.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            prev = str.charAt(i);
        }

        System.out.println(Math.min(one, zero));
    }
}
