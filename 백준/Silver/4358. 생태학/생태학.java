import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;

        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) break;
            
            map.put(str, map.getOrDefault(str, 0) + 1);
            cnt++;
        }

        List<String> keyList = new LinkedList<>(map.keySet());
        Collections.sort(keyList);

        for (String key : keyList) {
            bw.write(key + " ");
            bw.write(String.format("%.4f", (double) map.get(key) / cnt * 100) + "\n");
        }
        bw.close();
    }
}
