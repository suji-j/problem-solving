import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder str = new StringBuilder(br.readLine());

        for (int i = 0; i < str.length(); i++) {
            String curStr = str.substring(i);
            boolean flag = true;
            for (int j = 0; j < curStr.length() / 2; j++) {
                char s1 = curStr.charAt(j);
                char s2 = curStr.charAt(curStr.length() - 1 - j);

                if (s1 != s2) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                StringBuilder plus = new StringBuilder(str.substring(0, i));
                str.append(plus.reverse());
                break;
            }
        }

        bw.write(String.valueOf(str.length()));
        bw.close();
    }
}
