import java.io.*;
import java.util.StringTokenizer;

public class baek_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] black = new int[]{1, 1, 2, 2, 2, 8};
        int[] white = new int[6];

        for (int i = 0; i < 6; i++) {
            white[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(black[i] - white[i] + " ");
        }
    }
}
