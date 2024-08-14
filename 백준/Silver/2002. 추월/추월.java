import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        Queue<String> in = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            in.offer(br.readLine());
        }

        Queue<String> out = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            out.offer(br.readLine());
        }

        while (!out.isEmpty()) {
            String outCar = out.poll();
            if (!in.peek().equals(outCar)) {
                cnt++;
                in.remove(outCar);
            } else {
                in.poll();
            }
        }

        System.out.println(cnt);
    }
}
