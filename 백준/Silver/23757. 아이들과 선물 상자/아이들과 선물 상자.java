import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            gift.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int[] kid = new int[m];
        for (int i = 0; i < m; i++) {
            kid[i] = Integer.parseInt(st.nextToken());
        }

        boolean happy = true;
        for (int i = 0; i < m; i++) {
            int curGift = gift.poll();
            if (gift.isEmpty()) {
                happy = false;
                break;
            }

            if (kid[i] > curGift) {
                happy = false;
                break;
            }

            curGift -= kid[i];
            if (curGift > 0) {
                gift.add(curGift);
            }
        }

        bw.write(String.valueOf(happy ? 1 : 0));
        bw.close();
    }
}
