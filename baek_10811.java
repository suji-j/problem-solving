import java.io.*;
import java.util.StringTokenizer;

public class baek_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int cnt = 0; cnt < M; cnt++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int num = j;

            for (int k = 0; k <= (j - i); k++) {
                for (int m = i; m < num; m++) {
                    int tmp = arr[m + 1];
                    arr[m + 1] = arr[m];
                    arr[m] = tmp;
                }
                num--;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
