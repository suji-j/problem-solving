import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> student = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            student.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                student.put(name, student.get(name) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entry = new ArrayList<>(student.entrySet());
        entry.sort((o1, o2) -> {
            int compare = o2.getValue() - o1.getValue();
            if (compare == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return compare;
        });

        for (Map.Entry<String, Integer> map : entry) {
            bw.write(map.getKey() + " " + map.getValue() + "\n");
        }
        bw.close();
    }
}
