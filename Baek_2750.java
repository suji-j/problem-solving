package BaekJoon;
//2750
import java.io.*;

public class Baek_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for (int i=0; i<num ; i++){
            int count = Integer.parseInt(br.readLine());
            arr[i] = count;
        }

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-1; j++){
                if (arr[i] < arr[j]){
                    num = arr[i];
                    arr[i] = arr[j];
                    arr[j] = num;
                }
            }
        }

        for (int i=0; i<arr.length; i++){
            bw.write(arr[i] + "\n");
        }

        bw.close();
        br.close();
    }
}
