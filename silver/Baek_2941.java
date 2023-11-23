package BaekJoon;
//2941
import java.io.*;
public class Baek_2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String croaStr = br.readLine();

        croaStr = croaStr.replace("c=", "a");
        croaStr = croaStr.replace("c-", "a");
        croaStr = croaStr.replace("dz=", "a");
        croaStr = croaStr.replace("d-", "a");
        croaStr = croaStr.replace("lj", "a");
        croaStr = croaStr.replace("nj", "a");
        croaStr = croaStr.replace("s=", "a");
        croaStr = croaStr.replace("z=", "a");

        int checkCroaNum = croaStr.length();
        bw.write(checkCroaNum + "");

        bw.close();
        br.close();
    }
}
