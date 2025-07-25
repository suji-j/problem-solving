import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        HashSet<String> set = new HashSet<>();
        int result = 0, strLength = arr[0].length();
        boolean flag = false;

        while (!flag) {
            for (int i = 1; i <= strLength; i++) {
                for (String str : arr) {
                    String cur = str.substring(str.length() - i);
                    if (!set.contains(cur)) {
                        set.add(cur);
                        result = i;
                    } else {
                        set.clear();
                        break;
                    }
                }

                if (set.size() == n) {
                    flag = true;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
