package BaekJoon;
//1546
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1546 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine()); //과목
        double[] score = new double[num];
        st = new StringTokenizer(br.readLine());
        double avg =0;

        for (int i=0; i<num; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);
        double max = score[num-1];

        for (int i=0; i<score.length; i++){
            score[i] = (score[i]/max)*100;
            avg += score[i];
        }

        //bw.write(Arrays.toString(score) + "\n");
        avg = avg/(double)num;
        bw.write(avg +"");
        br.close();
        bw.close();
    }
}