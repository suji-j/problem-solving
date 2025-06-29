import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Re", 0);
        map.put("Pt", 0);
        map.put("Cc", 0);
        map.put("Ea", 0);
        map.put("Tb", 0);
        map.put("Cm", 0);
        map.put("Ex", 0);

        int total = 0;
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String order = st.nextToken();
                if (map.containsKey(order)) {
                    map.put(order, map.get(order) + 1);
                }
                total++;
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            double ratio = (double) cnt / total;
            bw.write(String.format("%s %d %.2f\n", entry.getKey(), entry.getValue(), ratio));
        }
        bw.write("Total " + total + " 1.00");
        bw.close();
    }
}
