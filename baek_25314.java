import java.io.*;
import java.util.StringTokenizer;

public class baek_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int cnt = num / 4;
        for (int i = 0; i < cnt; i++) {
            System.out.print("long ");
        }

        System.out.println("int");

    }
}
