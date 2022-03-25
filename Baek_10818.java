package BaekJoon;
//10818
import java.io.*;
import java.util.StringTokenizer;

public class Baek_10818 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int x = Integer.parseInt(br.readLine());
        int[] array = new int[x];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<x;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = array[0];
        int min = array[0];

        for (int i=0; i<array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        bw.write(min+ " ");
        bw.write(max +"");
        bw.close();
        br.close();
    }
}
