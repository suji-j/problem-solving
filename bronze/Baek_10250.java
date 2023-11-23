package BaekJoon;
//10250
import java.io.*;
import java.util.StringTokenizer;

public class Baek_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        int numH = 0;
        int numW = 0;

        for (int i=0; i<test; i++){
            int count =0;
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            outerLoop :
            for (int j=1; j<=W; j++){
                for (int k=1; k<=H; k++){
                    count ++;
                    if (count == N){
                        numH = k;
                        numW = j;
                        break outerLoop;
                    }
                }
            }
            if (numW < 10){
                bw.write(numH + "0" + numW +"\n");
            } else {
                bw.write(numH +"" + numW + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
