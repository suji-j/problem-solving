import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int sum = 0, time = 0;
        while (!bridge.isEmpty()) {
            time++;
            sum -= bridge.poll();

            if (truck.isEmpty()) {
                continue;
            }

            if (truck.peek() + sum <= l) {
                int cur = truck.poll();
                sum += cur;
                bridge.add(cur);
            } else {
                bridge.add(0);
            }
        }

        bw.write(String.valueOf(time));
        bw.close();
    }
}
