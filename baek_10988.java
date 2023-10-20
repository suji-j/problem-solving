import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char arr[] = new char[str.length()];
        int bool = 0;

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        if (arr.length == 1) {
            bool = 0;
        } else {
            for (int i = 1; i <= arr.length; i++) {
                if (arr[i - 1] != arr[str.length() - i]) {
                    bool++;
                }
            }
        }

        if (bool == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
