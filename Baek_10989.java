package BaekJoon;
//10989
import java.awt.*;
import java.io.*;
public class Baek_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i=0; i<cnt; i++){
            arr[Integer.parseInt(br.readLine())] ++;
        }

        for (int i=1; i<10001; i++){
            while(arr[i] > 0){
                bw.write(i + "\n");
                arr[i]--;
            }
        }
        bw.close();
        br.close();
    }
}
