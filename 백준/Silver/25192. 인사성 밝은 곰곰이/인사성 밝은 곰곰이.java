import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                map.clear();
                map.put("ENTER", 1);
            } else {
                if (map.containsKey("ENTER") && !map.containsKey(str)) {
                    map.put(str, 1);
                    result++;
                } else if (map.containsKey("ENTER") && map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                }
            }
        }

        System.out.println(result);
    }
}