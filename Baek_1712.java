package BaekJoon;
//1712
import java.io.*;
import java.util.StringTokenizer;

public class Baek_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (B >= C){
            bw.write("-1");
        }
        else{
            bw.write((A/(C-B)) + 1 + "");
        }

        bw.close();
        br.close();
    }
}
