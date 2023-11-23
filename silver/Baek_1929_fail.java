package BaekJoon;
//1929
import java.io.*;
import java.util.StringTokenizer;

public class Baek_1929_fail {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = a; i<= b ; i++){
            for (int j = 1; j<=i; j++){
                if (i % j ==0){
                    count++;
                }
            }
            if (count == 2){
                bw.write(i +"\n");
            }
            count =0;
        }

        br.close();
        bw.close();
    }
}
