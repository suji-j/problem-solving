package BaekJoon;
//10871
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baek_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1;
        int N, X = 0;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st2.nextToken());  //몇 개
        X = Integer.parseInt(st2.nextToken());  //몇 보다 작은 수

        st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N ; i++){
             int num = Integer.parseInt(st1.nextToken());
             if (num < X){
                 bw.write(num + " ");
             }
        }
        bw.close();
    }
}
