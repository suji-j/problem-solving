package BaekJoon;
//2941
import java.io.*;
import java.util.*;

public class Baek_2941_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] croaAlpa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = br.readLine();
        char[] croaStr = str.toCharArray();
        String[] strArr = new String[croaStr.length];
        int croaCount =0;
        int nullCount =0;

        for (int i = 0; i<croaStr.length-1; i++){
            String str1 = String.valueOf(croaStr[i]).concat(String.valueOf(croaStr[i+1]));
            //bw.write(str1 + "\n");
            for (int j=0; j<croaAlpa.length; j++){
                if (str1.contains(croaAlpa[j])){
                    strArr[i] = str1;
                }
            }
        }
        bw.write(Arrays.toString(strArr) + "\n");

        for (int i=0; i< croaAlpa.length; i++){
            /*if (list.contains(croaAlpa[i]) == true){
                ++croaCount;
            }*/
            for (int j =0; j<strArr.length; j++){
                if (strArr[j] != null){
                    if(strArr[j].contains(croaAlpa[i])){
                        croaCount++;
                    }
                }

            }
        }
        bw.write(croaCount + "\n");

        int num = str.length() - croaCount;

        bw.write(num +"");


        bw.close();
        br.close();
    }
}
