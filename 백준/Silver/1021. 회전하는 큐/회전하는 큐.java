import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> d = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            d.addLast(i);
        }

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (d.indexOf(num) <= d.size() / 2) {
                while (d.getFirst() != num) {
                    d.addLast(d.removeFirst());
                    cnt++;
                }
            } else {
                while (d.getFirst() != num) {
                    d.addFirst(d.removeLast());
                    cnt++;
                }
            }
            d.removeFirst();
        }

        System.out.println(cnt);
    }
}
