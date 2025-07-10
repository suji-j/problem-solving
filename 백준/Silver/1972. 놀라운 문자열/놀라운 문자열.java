import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while (!(str = br.readLine()).equals("*")) {
            boolean flag = false;

            for (int i = 1; i < str.length(); i++) {
                HashSet<String> set = new HashSet<>();
                for (int j = 0; j < str.length() - i; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(j)).append(str.charAt(j + i));
                    if (set.contains(sb.toString())) {
                        bw.write(str + " is NOT surprising.\n");
                        flag = true;
                        break;
                    }
                    set.add(sb.toString());
                }
                if (flag) break;
            }

            if (!flag) {
                bw.write(str + " is surprising.\n");
            }
        }
        bw.close();
    }
}
