package BaekJoon;
//10951
import java.io.*;
import java.util.StringTokenizer;

public class Baek_10951_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;
        int a =0;
        int b =0;


        while((str= br.readLine()) != ""){
            st = new StringTokenizer(str);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bw.write(a + b +"\n");

            str = br.readLine();
        }

        br.close();
        bw.close();
    }
}
