package BaekJoon;

import java.io.*;
import java.util.Stack;
import java.util.Scanner;
import java.util.StringTokenizer;

//10828
public class Baek_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        for (int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")){
                int count = Integer.parseInt(st.nextToken());
                stack.push(count);
            } else if (str.equals("pop")){
                if (stack.empty() == false){
                    bw.write(stack.pop() + "\n");
                } else{
                    bw.write("-1\n");
                }
            } else if (str.equals("size")){
                bw.write(stack.size()+"\n");
            } else if (str.equals("empty")){
                if (stack.empty() == true){
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(str.equals("top")){
                if (stack.empty() == false){
                    bw.write(stack.peek()+"\n");
                } else{
                    bw.write("-1\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}
