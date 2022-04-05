package BaekJoon;
//1026
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        int[] A = new int[num];
        Integer[] B = new Integer[num];
        int sum =0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<A.length; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<B.length; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i=0; i<A.length; i++){
            sum += A[i]*B[i];
        }

        bw.write(sum +"");
        bw.close();
        br.close();
    }
}
