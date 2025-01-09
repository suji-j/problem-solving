import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                int value = map.get(str) + 1;
                map.put(str, value);
            } else {
                map.put(str, 1);
            }
        }

        int max = 0;
        String maxStr = "";
        for (String str : map.keySet()) {
            int value = map.get(str);
            if (max < value) {
                max = value;
                maxStr = str;
            } else if (max == value) {
                if (maxStr.compareTo(str) > 0) {
                    maxStr = str;
                }
            }
        }

        System.out.println(maxStr);
    }
}