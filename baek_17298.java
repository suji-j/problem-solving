import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> nge = new Stack<>();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];

        for (int i=0; i<num;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=num-1; i>=0; i--){
            int a = arr[i];
            while(stack.empty()==false && a >= stack.peek()){
                stack.pop();
            }
            if (stack.empty() == true){
                nge.add(-1);
            } else{
                nge.add(stack.peek());
            }
            stack.add(a);
        }
        while(nge.empty() == false){
            bw.write(nge.pop()+ " ");
        }

        br.close();
        bw.close();
    }
}