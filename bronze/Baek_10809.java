package BaekJoon;
//10809
import java.io.*;
public class Baek_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        for (char a = 97; a<123; a++){
            bw.write(str.indexOf(a) + " ");
        }

        br.close();
        bw.close();
    }
}
