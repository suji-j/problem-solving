import java.io.*;
import java.util.StringTokenizer;

public class baek_5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (num1 == 0 && num2 == 0) {
                break;
            }

            if (num1 < num2) {
                if (num2 % num1 == 0) {
                    System.out.println("factor");
                } else {
                    System.out.println("neither");
                }
            } else {
                if (num1 % num2 == 0) {
                    System.out.println("multiple");
                } else {
                    System.out.println("neither");
                }
            }
        }
    }
}
