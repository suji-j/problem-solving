package BaekJoon;
//1874
import java.io.*;
import java.util.Stack;

public class Baek_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder str = new StringBuilder();
        boolean flag = true;
        int x=0;

        for (int i=0; i<num ; i++){
            int cnt = Integer.parseInt(br.readLine());
            if (cnt >= x){
                for (int a=(x+1); a<= cnt; a++){
                    stack.push(a);
                    str.append("+").append("\n");
                }
                x=cnt;
            }
            if(stack.peek() != cnt){
                bw.write("NO");
                flag = false;
                break;
            }else{
                stack.pop();
                str.append("-").append("\n");
            }

        }

        if (flag == true){
            bw.write(String.valueOf(str));
        }

        bw.close();
        br.close();
    }
}
