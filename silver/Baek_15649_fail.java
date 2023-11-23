package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

//15649
public class Baek_15649_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                if (i != j){
                    sb.append(i + " ").append(j);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
