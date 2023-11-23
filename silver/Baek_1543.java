package BaekJoon;
//1543 - 문서 검색

import java.io.*;

public class Baek_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String search = br.readLine();
        int cnt = 0;
        int index = 0;

        for (int i = index; i <= str.length() - search.length(); i++) {
            boolean isEquals = true;

            for (int j = 0; j < search.length(); j++) {
                if (str.charAt(i + j) != search.charAt(j)) {
                    isEquals = false;
                    break;
                }
            }

            if (!isEquals) {
                index++;
            } else {
                cnt++;
                index += search.length();
                i = index-1;
            }

        }
        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
