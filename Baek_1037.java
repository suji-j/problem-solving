package BaekJoon;
//1037-약수
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[cnt];
        int N =0;

        for (int i=0; i<cnt; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        N = arr[0] * arr[arr.length-1];

        bw.write(N+"");
        bw.close();
        br.close();
    }
}
