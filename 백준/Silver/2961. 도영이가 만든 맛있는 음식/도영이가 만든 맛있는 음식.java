import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, sourV = 1, bitterV = 0, min = Integer.MAX_VALUE;
    static int[] sourArr, bitterArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sourArr = new int[n];
        bitterArr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sourArr[i] = Integer.parseInt(st.nextToken());
            bitterArr[i] = Integer.parseInt(st.nextToken());
        }
        back(0);

        bw.write(String.valueOf(min));
        bw.close();
    }

    static void back(int start) {
        if (start != 0) {
            min = Math.min(min, Math.abs(sourV - bitterV));
        }

        for (int i = start; i < n; i++) {
            sourV *= sourArr[i];
            bitterV += bitterArr[i];
            back(i + 1);
            sourV /= sourArr[i];
            bitterV -= bitterArr[i];
        }
    }
}
