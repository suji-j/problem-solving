package BaekJoon;
//1978
import java.io.*;
import java.util.StringTokenizer;

public class Baek_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = 0;
        int prime =0;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] primeNum = new int[num];

        for (int i=0; i<num ; i++){
            primeNum[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i< num; i++){
            for (int j=1; j<= primeNum[i]; j++){
                if (primeNum[i] % j == 0){
                    count++;
                }
            }
            if (count == 2){
                prime++;
            }
            count =0;
        }

        bw.write(String.valueOf(prime));

        br.close();
        bw.close();
    }
}
