package BaekJoon;
//15650 중복X
import java.io.*;
import java.util.StringTokenizer;

public class Baek_15650 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i=0; i<N; i++){
            arr[i] = i+1;
        }
        visit = new boolean[arr.length];
        int n = arr.length; //전체 크기
        int r = M; //뽑을 개수

        dfs(arr, visit, 0, n, r);
        bw.write(sb+"");

        br.close();
        bw.close();
    }

    public static void dfs(int[] arr, boolean[] visit, int start, int n, int r){
        if (r == 0){
            for (int i=0; i<n; i++){
                if (visit[i] == true){
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<n;i++){
            visit[i] = true;
            dfs(arr, visit, i+1, n, r-1);
            visit[i] = false;
        }

    }
}
