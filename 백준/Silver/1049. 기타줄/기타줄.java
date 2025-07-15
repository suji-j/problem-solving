import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pack = new int[m];
        int[] piece = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            piece[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pack);
        Arrays.sort(piece);

        int buyPiece = piece[0] * n;
        int buyPack = pack[0] * (n / 6);

        if (n % 6 != 0) {
            if (piece[0] * (n % 6) > pack[0]) {
                buyPack += pack[0];
            } else {
                buyPack += (piece[0] * (n % 6));
            }
        }

        bw.write(Math.min(buyPiece, buyPack) + "");
        bw.close();
    }
}
