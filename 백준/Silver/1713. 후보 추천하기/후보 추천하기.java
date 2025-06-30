import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.size() < n || map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
                list.sort((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()));
                map.remove(list.get(0).getKey());
                map.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> Integer.compare(o1.getKey(), o2.getKey()));
        for (Map.Entry<Integer, Integer> entry : list) {
            bw.write(entry.getKey() + " ");
        }
        bw.close();
    }
}
