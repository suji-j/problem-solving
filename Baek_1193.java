package BaekJoon;
//1193
import java.io.*;
public class Baek_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int t = 1, b =1;
        int count = 1;
        int dia = 0;
        int bottom =1, top =1;

        while(true){
            dia += count;
            if ( dia >= num ){
                break;
            }
            count++;
        }

        if (count ==1){
            bw.write(t + "/" + b);
        } else if (count % 2 == 0){
            for (int i=0; i<count ;i ++){
                t = top;
                b = count-i;
                if (num == (dia-(count-(i+1)))){
                    break;
                }
                top++;
            }
            bw.write(t + "/" + b);
        } else if(count % 2 == 1){
            for (int i=count; i>0 ;i--){
                t = i;
                b = bottom;
                if (num == ((dia+1) - i)){
                    break;
                }
                bottom++;
            }
            bw.write(t + "/" + b);
        }
        bw.close();
        br.close();
    }
}
