package BaekJoon;
//1934-최소공배수

import java.io.*;
import java.util.StringTokenizer;

public class Baek_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A > B) {
                int temp = B;
                B = A;
                A = temp;
            }
            int Anum = A;
            int Bnum = B;

            int w = B % A;
            int max = 0;

            if (w != 0) {
                while (w != 0) {
                    B = A;
                    A = w;
                    w = B % A;
                }
                max = A;
            } else {
                max = A;
            }

            A = Anum / max;
            B = Bnum / max;

            int min = A * B * max;

            bw.write(min + "\n");
        }

        bw.close();
        br.close();
    }
}
