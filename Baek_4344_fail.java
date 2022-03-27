package BaekJoon;
//4344
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_4344_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int case1 = Integer.parseInt(br.readLine());        ;
        st = new StringTokenizer(br.readLine());
        int num = st.countTokens();
        int[] score = new int[num];

        for (int i =0; i<case1; i++){
            for (int j=0; i<score.length; j++){
                score[j] = Integer.parseInt(st.nextToken());
                bw.write(Arrays.toString(score));
            }
        }



        br.close();
        bw.close();
    }
}
