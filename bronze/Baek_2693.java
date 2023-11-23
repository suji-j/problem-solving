package BaekJoon;
//2693-N번째 큰 수

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            bw.write(arr[arr.length - 3] + "\n");
        }

        bw.close();
        br.close();
    }
}
