import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> valid = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> min = new PriorityQueue<>((o1, o2) -> {
            int compare = o1.getValue() - o2.getValue();
            if (compare == 0) {
                return o1.getKey() - o2.getKey();
            }
            return compare;
        });

        PriorityQueue<Map.Entry<Integer, Integer>> max = new PriorityQueue<>((o1, o2) -> {
            int compare = o2.getValue() - o1.getValue();
            if (compare == 0) {
                return o2.getKey() - o1.getKey();
            }
            return compare;
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            valid.put(p, l);
            max.add(Map.entry(p, l));
            min.add(Map.entry(p, l));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                valid.put(p, l);
                min.add(Map.entry(p, l));
                max.add(Map.entry(p, l));
            } else if (order.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                valid.remove(p);
            } else {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    while (true) {
                        Map.Entry<Integer, Integer> tmp = max.peek();
                        int p = tmp.getKey();
                        if (!valid.containsKey(p) || valid.get(p) != tmp.getValue()) {
                            max.poll();
                        } else {
                            bw.write(max.peek().getKey() + "\n");
                            break;
                        }
                    }
                } else {
                    while (true) {
                        Map.Entry<Integer, Integer> tmp = min.peek();
                        int p = tmp.getKey();
                        if (!valid.containsKey(p) || valid.get(p) != tmp.getValue()) {
                            min.poll();
                        } else {
                            bw.write(min.peek().getKey() + "\n");
                            break;
                        }
                    }
                }
            }
        }

        bw.close();
    }
}
