import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] pass = new int[4];
    static int[] dna = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        dna = new int[4];
        for (int i = 0; i < 4; i++) {
            dna[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < p; i++) {
            addChar(arr[i]);
        }
        if (checkCorrect()) {
            ans++;
        }

        for (int i = p; i < s; i++) {
            addChar(arr[i]);
            removeChar(arr[i - p]);
            if (checkCorrect()) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }

    static void addChar(char c) {
        switch (c) {
            case 'A':
                pass[0]++;
                break;
            case 'C':
                pass[1]++;
                break;
            case 'G':
                pass[2]++;
                break;
            case 'T':
                pass[3]++;
                break;
        }
    }

    static void removeChar(char c) {
        switch (c) {
            case 'A':
                pass[0]--;
                break;
            case 'C':
                pass[1]--;
                break;
            case 'G':
                pass[2]--;
                break;
            case 'T':
                pass[3]--;
                break;
        }
    }

    static boolean checkCorrect() {
        for (int i = 0; i < 4; i++) {
            if (pass[i] < dna[i]) {
                return false;
            }
        }
        return true;
    }
}
