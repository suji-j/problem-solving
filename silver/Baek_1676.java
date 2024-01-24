import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        long fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;

            if (fact % 10 == 0) {
                while (fact % 10 == 0) {
                    count++;
                    fact /= 10;
                }
            }

            fact %= 10000; // 자릿수 줄이기
        }

        System.out.println(count);
    }
}