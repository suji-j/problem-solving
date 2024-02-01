import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            if (order.equals("add")) {
                if (!list.contains(num)) {
                    list.add(num);
                } else {
                    continue;
                }
            } else if (order.equals("remove")) {
                if (list.contains(num)) {
                    list.remove(Integer.valueOf(num));
                } else {
                    continue;
                }
            } else if (order.equals("check")) {
                if (list.contains(num)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (order.equals("toggle")) {
                if (list.contains(num)) {
                    list.remove(Integer.valueOf(num));
                } else {
                    list.add(num);
                }
            } else if (order.equals("all")) {
                list.clear();
                for (int j = 1; j <= 20; j++) {
                    list.add(j);
                }
            } else if (order.equals("empty")) {
                list.clear();
            }
        }
        System.out.println(sb);
    }
}