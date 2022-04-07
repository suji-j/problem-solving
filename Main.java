package BaekJoon;
//9012
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringTokenizer st;
        boolean check = true;
        for (int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            String[] arr = new String[];
            if (stack.peek().equals(")")){
                bw.write("NO\n");
            } else if (stack.peek().equals("(")){
                if (stack.pop().equals("("))
            }


        }
        br.close();
        bw.close();
    }
}
