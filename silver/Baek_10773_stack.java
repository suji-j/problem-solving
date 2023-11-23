package BaekJoon;
//10773
import java.io.*;
import java.util.Stack;

public class Baek_10773_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int sum =0;

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<num ; i++){
            int a = Integer.parseInt(br.readLine());
            if (a != 0){
                stack.push(a);
            } else{
                stack.pop();
            }
        }

        for (int i=0; i< stack.size(); i++){
            sum += stack.get(i);
        }

        bw.write(sum +"");
        bw.close();
        br.close();
    }
}
