package BaekJoon;
//4344
import java.io.*;
import java.util.StringTokenizer;

public class Baek_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        String[] arr = new String[0];

        for (int i =0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int sum =0;
            double avg = 0;
            arr = new String[num];
            for (int j = 0; j<num ; j++){
                arr[j] = st.nextToken();
                sum += Integer.parseInt(arr[j]);
            }
            avg = (double)sum/num;
            //bw.write(avg + "");
            int count =0;
            for (int j =0; j<arr.length; j++){
                if (Integer.parseInt(arr[j]) > avg){
                    count++;
                }
            }
            double avgStu = (double)count/num*100;
            bw.write(String.format("%.3f", avgStu) + "%\n");
        }
        bw.close();
        br.close();
    }
}
