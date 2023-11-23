package BaekJoon;
//11653
import java.io.*;
public class Baek_11653 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int div = num;
        if (num == 1){
            bw.write("");
        } else{
            for (int i=2; i<=num; i++){
                while(div%i == 0){
                    div = div/i;
                    bw.write(i +"\n");
                }
            }
        }
        bw.close();
        br.close();
    }
}
