import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int currentNum = N;

        while (currentNum > 0) {
            if (currentNum % B < 10) {
                sb.append(currentNum % B);
            } else {
                sb.append((char) (currentNum % B - 10 + 'A'));
            }
            currentNum /= B;
        }

        System.out.println(sb.reverse());
    }
}
