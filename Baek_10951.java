package BaekJoon;
//10951
import java.io.*;
import java.util.StringTokenizer;

public class Baek_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int a =0;
        int b =0;

        while(true){
            String str = br.readLine();
            if (str == null){
                break;
            }else{
                StringTokenizer st = new StringTokenizer(str);
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if ((a>0&&a<10) && (b>0&&b<10)){
                    bw.write(a + b +"\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}
