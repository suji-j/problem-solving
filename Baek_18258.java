package BaekJoon;
//18258
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> qu = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int last =0;

        for (int i=0; i<num ; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                qu.add(a);
                last = a;
            } else if (str.equals("pop")){
                if (qu.isEmpty() == true){
                    bw.write("-1\n");
                } else {
                    bw.write(qu.poll() + "\n");
                }
            } else if (str.equals("size")){
                bw.write(qu.size() + "\n");
            } else if(str.equals("empty")){
                if (qu.isEmpty() == true){
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(str.equals("front")){
                if (qu.isEmpty() == true){
                    bw.write("-1\n");
                } else {
                    bw.write(qu.peek() + "\n");
                }
            } else if(str.equals("back")){
                if (qu.isEmpty() == true){
                    bw.write("-1\n");
                } else{
                    bw.write(last + "\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}
