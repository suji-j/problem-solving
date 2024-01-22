import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }

            char[] arr = new char[num.length()];

            for (int i = 0; i < num.length(); i++) {
                arr[i] = num.charAt(i);
            }

            boolean isPalin = true;
            for (int i = 0; i < arr.length / 2; i++) {
                isPalin = arr[i] == arr[arr.length - (i + 1)];
                if (!isPalin) {
                    break;
                }
            }

            if (isPalin) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}