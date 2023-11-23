package BaekJoon;
//2581
import java.io.*;

public class Baek_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int index=0;
        int minPrime =0, sum =0;

        for (int i=M ; i<=N; i++){
            int count =0;
            for (int j=1; j<=i ; j++){
                if (i%j ==0){
                    count++;
                }
            }
            if (count == 2){
                sum += i;
                index++;
                if (index == 1){
                    minPrime = i;
                }
            }
        }
        if (minPrime == 0){
            bw.write("-1");
        } else{
            bw.write(sum + "\n" + minPrime);
        }

        bw.close();
        br.close();
    }
}
