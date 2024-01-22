import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
            list.add(Integer.parseInt(st.nextToken()));
            list.add(Integer.parseInt(st.nextToken()));
            Collections.sort(list);

            if (list.get(0) == 0 && list.get(1) == 0 && list.get(2) == 0) {
                break;
            }

            if (Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2) == Math.pow(list.get(2), 2)) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }

        System.out.println(sb);
    }
}