import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int cnt = Integer.parseInt(br.readLine());
            map.put(name, new ArrayList<>());

            for (int j = 0; j < cnt; j++) {
                map.get(name).add(br.readLine());
            }
        }

        for (int i = 0; i < m; i++) {
            String qName = br.readLine();
            int qType = Integer.parseInt(br.readLine());

            if (qType == 0) {
                ArrayList<String> group = map.get(qName);
                Collections.sort(group);
                for (String member : group) {
                    bw.write(member + "\n");
                }
            } else {
                for (String girlGroup : map.keySet()) {
                    ArrayList<String> group = map.get(girlGroup);
                    if (group.contains(qName)) {
                        bw.write(girlGroup + "\n");
                    }
                }
            }
        }

        bw.close();
    }
}
