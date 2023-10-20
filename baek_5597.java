import java.io.*;

public class baek_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt[] = new int[30];

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num - 1] += 1;
        }

        for (int i = 0; i < 30; i++) {
            if (cnt[i] == 0) {
                System.out.println(i + 1);
            }
        }
    }
}
