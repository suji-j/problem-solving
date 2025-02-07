import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int hd = 0;
        for (int i = 0; i < m; i++) {
            int[] dna = new int[4];

            for (int j = 0; j < n; j++) {
                char ch = arr[j].charAt(i);
                if (ch == 'A') dna[0]++;
                else if (ch == 'C') dna[1]++;
                else if (ch == 'G') dna[2]++;
                else dna[3]++;
            }

            int bestCount = dna[0];
            char bestChar = 'A';
            if (dna[1] > bestCount) {
                bestChar = 'C';
                bestCount = dna[1];
            }
            if (dna[2] > bestCount) {
                bestChar = 'G';
                bestCount = dna[2];
            }
            if (dna[3] > bestCount) {
                bestChar = 'T';
                bestCount = dna[3];
            }

            sb.append(bestChar);
            hd += (n - bestCount);
        }

        System.out.println(sb.toString());
        System.out.println(hd);
    }
}
