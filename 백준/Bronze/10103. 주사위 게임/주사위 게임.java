import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int c = 100, s = 100;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cDice = Integer.parseInt(st.nextToken());
            int sDice = Integer.parseInt(st.nextToken());

            if (cDice < sDice) {
                c -= sDice;
            } else if (cDice > sDice) {
                s -= cDice;
            }
        }

        bw.write(c + "\n" + s);
        bw.close();
    }
}
