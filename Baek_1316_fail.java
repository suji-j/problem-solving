package BaekJoon;

import java.io.*;
import java.util.Arrays;

//1316
public class Baek_1316_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] arr;
        int count = 0;
        int notCount =0;

        for (int i=0; i<num; i++){
            String str = br.readLine();
            arr = str.split("");
            if(arr.length == 1){
                count++;
            } else{
                for (int k=0; k<arr.length-1; k++){
                    if (arr[k] != arr[k+1]){
                        for (int j=2; j<arr.length-k; j++){
                            if (arr[k] == arr[k+j]){
                                notCount++;
                                break;
                            }
                            else{
                                continue;
                            }
                        }
                    }
                }
            }

        }

        bw.write("그룹이 아닌 수 : " + notCount + "\n");
        bw.write("그룹인 수 : " + (num-notCount));
        bw.close();
        br.close();
    }
}
