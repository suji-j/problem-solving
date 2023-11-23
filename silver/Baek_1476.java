package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;
//1476
public class Baek_1476 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cE =1, cS=1, cM=1, year=0;

        while(true){
            year++;
            if (cE ==E && cS ==S && cM==M){
                bw.write(year+"");
                break;
            }
            cE++;
            cS++;
            cM++;
            if (cE > 15){
                cE = 1;
            }
            if (cS > 28){
                cS = 1;
            }
            if (cM > 19){
                cM = 1;
            }
        }
        bw.close();
        br.close();
    }
}
