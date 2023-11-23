package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

//2609-최대공약수와 최소공배수
public class Baek_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (A > B) {
            int temp = A;
            A = B;
            B = temp;
        }
        int saveA = A;
        int saveB = B;
        int w = B % A;
        int max = 0;

        if (w == 0) {
            bw.write(A + "\n");
            bw.write(B + "\n");
        } else {
            while (w != 0) {
                B = A;
                A = w;
                w = B % A;
            }
            max = A;
            bw.write(max + "\n");
            A = saveA / max;
            B = saveB / max;
            bw.write(A * B * max + "\n");
        }


        br.close();
        bw.close();
    }
}
