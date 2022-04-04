package BaekJoon;
//7568
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] weight = new int[num];
        int[] tall = new int[num];
        int[] score = new int[num];

        for (int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            tall[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<weight.length; i++){
            int count =0;
            for (int j=0; j<weight.length; j++){
                if (weight[i] < weight[j] && tall[i] < tall[j]){
                    count ++;
                }
            }
            score[i] = count;
        }

        for (int i=0; i<weight.length; i++){
            bw.write(score[i]+1 + "\n");
        }
        bw.close();
        br.close();
    }
}
