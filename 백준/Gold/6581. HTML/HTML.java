import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        StringBuilder sb = new StringBuilder();
        int curWord = 0;

        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);

            while (st.hasMoreTokens()) {
                String cur = st.nextToken();
                
                if (cur.isEmpty()) continue;
                int wordCnt = cur.length();

                if (cur.equals("<br>")) {
                    sb.append("\n");
                    curWord = 0;
                    continue;
                } else if (cur.equals("<hr>")) {
                    if (curWord != 0) {
                        curWord = 0;
                        sb.append("\n");
                    }
                    sb.append("--------------------------------------------------------------------------------\n");
                    continue;
                }

                if (curWord == 0) {
                    sb.append(cur);
                    curWord = wordCnt;
                } else if (curWord + 1 + wordCnt > 80) {
                    sb.append("\n").append(cur);
                    curWord = wordCnt;
                } else {
                    sb.append(" ").append(cur);
                    curWord += wordCnt + 1;
                }
            }
        }

        if (sb.charAt(sb.length() - 1) != '\n') {
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
