package BaekJoon;
//8958
import java.awt.font.FontRenderContext;
import java.io.*;
import java.util.Arrays;

public class Baek_8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        String[] test = new String[num1];
        int[] scoreArr = new int[num1];


        for (int i=0; i< test.length; i++){
            test[i] = br.readLine();
            String[] split = test[i].split("");
            int count=1;
            int score =0;
            //bw.write(Arrays.toString(split));
            for (int j=0; j< split.length; j++){
                if (split[j].equals("O")){
                    score += (count++);
                }
                else{
                    count = 1;
                }
            }
            scoreArr[i] = score;
            bw.write(scoreArr[i] + "\n");
        }

        bw.close();
        br.close();
    }
}
