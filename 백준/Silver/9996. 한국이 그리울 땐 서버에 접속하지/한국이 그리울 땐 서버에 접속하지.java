import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String file = br.readLine();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < file.length(); i++) {
            if (file.charAt(i) != '*') {
                sb.append(file.charAt(i));
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        list.add(sb.toString());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int pre = list.get(0).length();
            int post = list.get(1).length();

            if (pre + post <= str.length()) {
                if (str.substring(0, pre).equals(list.get(0)) && str.substring(str.length() - post, str.length()).equals(list.get(1))) {
                    bw.write("DA\n");
                    continue;
                }
            }
            bw.write("NE\n");
        }

        bw.close();
        br.close();
    }
}