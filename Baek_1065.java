package BaekJoon;

import java.io.*;

//1065 -한수
public class Baek_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        if (num < 100) {
            bw.write(num + "");
        } else {
            int hansu = 99;

            for (int i = 100; i <= num; i++) {
                int n1 = i / 100 % 10;
                int n2 = i / 10 % 10;
                int n3 = i % 10;

                if (n2 * 2 == n1 + n3) {
                    hansu++;
                }
            }
            if (num == 1000) {
                hansu--;
            }
            bw.write(hansu + "");
        }

        bw.close();
        br.close();
    }
}
