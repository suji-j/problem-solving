package BaekJoon;
//11021
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baek_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for (int i=1; i<=T;i++){
            st = new StringTokenizer(bf.readLine());
            bw.write("Case #"+i+": ");
            bw.write(Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken())+ "\n");
        }
        bw.close();
    }
}
