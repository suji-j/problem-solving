package BaekJoon;

import java.io.*;
//1427
public class Baek_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char num = 0;
        int sort = Integer.parseInt(br.readLine());
        String sort1 = String.valueOf(sort);
        char[] arr = new char[sort1.length()];
        for (int i=0; i<arr.length; i++){
            arr[i] = sort1.charAt(i);
        }

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-1; j++){
                if (Integer.parseInt(String.valueOf(arr[i])) > Integer.parseInt(String.valueOf(arr[j]))){
                    num = arr[j];
                    arr[j] = arr[i];
                    arr[i] = num;
                }
            }
        }

        String str = new String(arr);
        bw.write(str);

        bw.close();
        br.close();
    }
}
