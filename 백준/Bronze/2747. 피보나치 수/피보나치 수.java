import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] fib = new int[num + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(fib[num]);
    }
}
