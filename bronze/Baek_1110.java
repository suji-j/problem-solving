package BaekJoon;
//1110
import javax.management.StringValueExp;
import java.io.*;

public class Baek_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int temp = N;
        int newNum = 0;
        int sum = 0;

        sum = (temp/10)+(temp%10);

        while(true){
            newNum = ((temp%10)*10)+(sum%10);
            sum = (temp%10) + (sum%10);
            temp = newNum;

            count++;

            if (N == newNum){
                break;
            }
        }
        bw.write(String.valueOf(count));
        br.close();
        bw.close();
    }
}
