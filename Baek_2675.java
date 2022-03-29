package BaekJoon;
//2675
import java.io.*;
import java.util.StringTokenizer;

public class Baek_2675 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for (int i=0; i<num ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            char[] arrChar = str.toCharArray();
            for (int j=0; j<arrChar.length; j++){
                for (int k=1; k<=a; k++){
                    bw.write(arrChar[j]);
                }
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}