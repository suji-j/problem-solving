package BaekJoon;
//5622
import java.io.*;
public class Baek_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char[] phoneNum = str.toCharArray();
        int count =0;
        String[] dialog = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        for (int i=0; i<dialog.length; i++){
            for (int j =0; j<phoneNum.length;j++){
                if (dialog[i].contains(String.valueOf(phoneNum[j]))){
                    count += (3+i);
                }
            }
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.close();

    }
}
