package BaekJoon;
//2164
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for (int i=1; i<=num; i++){
            queue.offer(i);
        }

        for (int i=0; i<num-1; i++){
            queue.poll();
            queue.offer(queue.poll());
        }
        bw.write(queue.peek() +"");


        bw.close();
        br.close();
    }
}
