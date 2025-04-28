import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                int o1Cnt = 0, o2Cnt = 0;
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) > 47 && o1.charAt(i) < 58) {
                        o1Cnt += o1.charAt(i) - '0';
                    }
                }
                for (int i = 0; i < o2.length(); i++) {
                    if (o2.charAt(i) > 47 && o2.charAt(i) < 58) {
                        o2Cnt += o2.charAt(i) - '0';
                    }
                }

                if (o1Cnt != o2Cnt) {
                    return o1Cnt - o2Cnt;
                }

                return o1.compareTo(o2);
            }
        });

        for (String str : list) {
            bw.write(str + "\n");
        }
        bw.close();
    }
}
