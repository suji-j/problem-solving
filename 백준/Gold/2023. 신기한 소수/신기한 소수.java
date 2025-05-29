import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String str = "";

        back(str);

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }

        bw.close();
    }

    static void back(String num) {
        if (num.length() == n) {
            pq.add(num);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            num += i;
            if (prime(num)) {
                back(num);
            }
            num = num.substring(0, num.length() - 1);
        }
    }

    static boolean prime(String num) {
        int number = Integer.parseInt(num);

        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
