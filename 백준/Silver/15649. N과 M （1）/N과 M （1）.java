import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] bool;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bool = new boolean[N];
        arr = new int[M];
        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth){
        if (depth == M){
            for (int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++){
            if (bool[i] == false){
                bool[i] = true;
                arr[depth] = i+1;

                dfs(N, M ,depth+1);

                bool[i] = false;
            }
        }
    }
}