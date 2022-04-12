package BaekJoon;
//2751
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<cnt; i++){
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }
        Collections.sort(arr);

        for (int i : arr){
            sb.append(i).append("\n");
        }

        bw.write(sb+"");

        bw.close();
        br.close();
    }
}
