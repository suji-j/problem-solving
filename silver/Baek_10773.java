package BaekJoon;
//10773
import java.io.*;
public class Baek_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] arr = new int[num];

        for (int i=0; i<arr.length; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] =a;
        }

        for (int i=1; i<arr.length; i++){
            int count =2;
            if (arr[i] == 0){
                while(true){
                    if (arr[i-1] != 0){
                        arr[i-1] = arr[i];
                        break;
                    } else{
                        if (arr[i-count] != 0){
                            arr[i-count] = arr[i];
                            break;
                        }
                        count++;
                    }
                }
            }
        }

        for (int i=0 ; i<arr.length; i++){
            if (arr[i] != 0){
                sum += arr[i];
            }
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}
