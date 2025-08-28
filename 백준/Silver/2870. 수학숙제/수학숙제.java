import java.io.*;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= 48 && arr[j] <= 57) {
                    sb.append(arr[j]);
                } else {
                    if (!sb.toString().isEmpty()) {
                        pq.add(new BigInteger(sb.toString()));
                        sb = new StringBuilder();
                    }
                }

                if (j == arr.length - 1 && !sb.toString().isEmpty()) {
                    pq.add(new BigInteger(sb.toString()));
                    sb = new StringBuilder();
                }
            }
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }
        bw.close();
    }
}
