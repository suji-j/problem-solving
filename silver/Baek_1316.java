package BaekJoon;

import java.io.*;
//1316
public class Baek_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int notGroup =0;

        for (int i =0; i<num; i++){
            String str = br.readLine();
            char[] charArr = str.toCharArray();
            outerLoop :
            if (charArr.length != 1){
                for (int j = 0; j<charArr.length-2; j++){
                    if (charArr[j] != charArr[j+1]){
                        for (int k=j+2; k< charArr.length; k++){
                            if (charArr[j] == charArr[k]){
                                notGroup ++;
                                break outerLoop;
                            }
                        }
                    }
                }
            }
        }
        bw.write((num-notGroup) + "");
        bw.close();
        br.close();
    }
}
