import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> cntMap = new HashMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();

                if (order.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    minQ.add(num);
                    maxQ.add(num);
                    cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
                } else {
                    if (cntMap.isEmpty()) continue;

                    if (Integer.parseInt(st.nextToken()) == -1) {
                        removeValid(minQ, cntMap);
                    } else {
                        removeValid(maxQ, cntMap);
                    }
                }
            }

            Integer max = getValid(maxQ, cntMap);
            Integer min = getValid(minQ, cntMap);
            if (max == null || min == null) {
                bw.write("EMPTY\n");
            } else {
                bw.write(max + " " + min + "\n");
            }
        }

        bw.close();
    }

    static int removeValid(PriorityQueue<Integer> pq, Map<Integer, Integer> cntMap) {
        while (!pq.isEmpty()) {
            int num = pq.poll();

            if (cntMap.getOrDefault(num, 0) > 0) {
                cntMap.put(num, cntMap.get(num) - 1);

                if (cntMap.get(num) == 0) {
                    cntMap.remove(num);
                }
                return num;
            }
        }
        return 0;
    }

    static Integer getValid(PriorityQueue<Integer> pq, Map<Integer, Integer> cntMap) {
        while (!pq.isEmpty()) {
            int num = pq.peek();

            if (cntMap.getOrDefault(num, 0) > 0) {
                return num;
            } else {
                pq.poll();
            }
        }
        return null;
    }

}
