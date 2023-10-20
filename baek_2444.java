import java.io.*;

public class baek_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            for (int j = 1; j <= cnt - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = cnt + 1; i < cnt * 2; i++) {
            for (int j = 1; j <= i - cnt; j++) {
                System.out.print(" ");
            }
            for (int j = cnt - 1; j >= i - cnt; j--) {
                System.out.print("*");
            }
            for (int j = cnt - 2; j >= i - cnt; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
