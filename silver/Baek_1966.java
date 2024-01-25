import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < testCase; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                q.add(number);
                list.add(number);
            }

            int check = 0;
            for (int j = 0; j < n; j++) {
                int num = q.remove();
                if (j == m) {
                    check = num;
                    q.add(0);
                    list.remove(Integer.valueOf(num));
                    list.add(0);
                } else {
                    q.add(num);
                }
            }

            int order = 0;
            while (true) {
                int max = Collections.max(list);
                int val = q.remove();

                if (val != Collections.min(list) || max > check) {
                    if (max == val) {
                        if (val >= check) {
                            order++;
                            list.remove(Integer.valueOf(val));
                        } else {
                            q.add(val);
                        }
                    } else if (max > val) {
                        q.add(val);
                    }
                } else {
                    order++;
                    break;
                }
            }
            System.out.println(order);
        }
    }
}