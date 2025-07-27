import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int num;
        Queue<Integer> q = new LinkedList<>();
        while ((num = Integer.parseInt(br.readLine())) != -1) {
            if (num == 0 && !q.isEmpty()) {
                q.poll();
            } else {
                if (q.size() < n) {
                    q.add(num);
                }
            }
        }

        if (q.isEmpty()) {
            bw.write("empty");
        } else {
            while (!q.isEmpty()) {
                bw.write(q.poll() + " ");
            }
        }
        bw.close();
    }
}
