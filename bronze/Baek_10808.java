package BaekJoon;
//10808
import java.io.*;
public class Baek_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        //char[] alpa = {'a', 'b','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'
        //, 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i=97; i< 123; i++){
            int count =0;
            for (int j=0; j<str.length(); j++){
                if (str.charAt(j) == i){
                    count++;
                }
            }
            bw.write(count + " ");
        }

        bw.close();
        br.close();
    }
}
