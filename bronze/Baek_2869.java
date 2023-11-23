package BaekJoon;
//2869
import java.io.*;
import java.util.StringTokenizer;

public class Baek_2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int cnt =0;

        if (V == A){
            cnt =1;
        } else{
            cnt = ((V-B-1)/ (A-B)) +1;
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
    }
}
