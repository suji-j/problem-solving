import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int idx = 0;
        while (idx < str.length()) {
            if (str.charAt(idx) == 'X') {
                int cntX = 0;
                while (idx < str.length() && str.charAt(idx) == 'X') {
                    cntX++;
                    idx++;
                }

                if (cntX % 2 != 0) {
                    bw = new BufferedWriter(new OutputStreamWriter(System.out));
                    bw.write("-1");
                    break;
                }

                int aCnt = cntX / 4;
                int bCnt = (cntX % 4) / 2;

                while (aCnt-- > 0) {
                    bw.write("AAAA");
                }
                while (bCnt-- > 0) {
                    bw.write("BB");
                }
            } else {
                bw.write(".");
                idx++;
            }
        }
        bw.close();
    }
}
