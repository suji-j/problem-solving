import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> extension = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] file = br.readLine().split("\\.");
            try {
                extension.put(file[1], extension.get(file[1]) + 1);
            } catch (NullPointerException e) {
                extension.put(file[1], 1);
            }
        }

        for (String str : extension.keySet()) {
            System.out.println(str + " " + extension.get(str));
        }
    }
}
