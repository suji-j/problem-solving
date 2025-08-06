import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ham = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            ham = Math.min(ham, n);
        }

        int drink = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int n = Integer.parseInt(br.readLine());
            drink = Math.min(drink, n);
        }

        bw.write(String.valueOf(ham + drink - 50));
        bw.close();
    }
}
