import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int cnt = 0;
        sb.append("<");
        while (!list.isEmpty()) {
            int num = list.remove();
            cnt++;

            if (cnt == k) {
                sb.append(num);
                if (!list.isEmpty()) {
                    sb.append(", ");
                }
                cnt = 0;
            } else {
                list.add(num);
            }
        }

        sb.append(">");

        System.out.println(sb);
    }
}