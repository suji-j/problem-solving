import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> sub = new HashMap<>();
        HashMap<String, Integer> nickname = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            nickname.put(str, nickname.getOrDefault(str, 0) + 1);
            int cnt = 0;

            for (int j = 1; j <= str.length(); j++) {
                String subStr = str.substring(0, j);
                if (sub.getOrDefault(subStr, 0) == 0) {
                    sub.put(subStr, sub.getOrDefault(subStr, 0) + 1);

                    if (cnt == 0) {
                        bw.write(subStr + "\n");
                    }
                    cnt++;
                }
            }

            if (cnt == 0) {
                if (nickname.get(str) > 1) {
                    sub.put(str, sub.get(str) + 1);
                    bw.write(str + sub.get(str) + "\n");
                } else {
                    bw.write(str + "\n");
                }

            }
        }

        bw.flush();
        bw.close();
    }
}
