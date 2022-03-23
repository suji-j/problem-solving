package BaekJoon;
//10871
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1;
        int N, X = 0;

        for (int i = 0 ; i < 2 ; i++){
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st2.nextToken());
        X = Integer.parseInt(st2.nextToken());
        bw.write(N+ X);
        }


        /*for (int i = 0; i < N ; i++){
             st = new StringTokenizer(br.readLine());
             if (Integer.parseInt(st.nextToken()) < X){
                 bw.write(Integer.parseInt(st.nextToken()));
             }

        }*/
        bw.close();
    }
}
