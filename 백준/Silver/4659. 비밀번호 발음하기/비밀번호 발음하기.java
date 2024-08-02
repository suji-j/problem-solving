import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while (!str.equals("end")) {
            String[] arr = str.split("");

            if (!vowel(arr)) {
                System.out.println("<" + str + "> is not acceptable.");
                str = br.readLine();
                continue;
            }

            if (!continuous(arr)) {
                System.out.println("<" + str + "> is not acceptable.");
                str = br.readLine();
                continue;
            }

            if (!eeoo(arr)) {
                System.out.println("<" + str + "> is not acceptable.");
                str = br.readLine();
                continue;
            }

            System.out.println("<" + str + "> is acceptable.");
            str = br.readLine();
        }

    }

    public static boolean vowel(String[] arr) {
        List<String> list = Arrays.asList("a", "e", "i", "o", "u");

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean continuous(String[] arr) {
        List<String> list = Arrays.asList("a", "e", "i", "o", "u");
        int vowel = 0;
        int consonant = 0;

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                vowel++;
                consonant = 0;
            } else {
                consonant++;
                vowel = 0;
            }

            if (vowel == 3 || consonant == 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean eeoo(String[] arr) {
        List<String> list = Arrays.asList("e", "o");
        String str = arr[0];
        int cnt = 1;

        for (int i = 1; i < arr.length; i++) {
            if (str.equals(arr[i])) {
                cnt++;
            } else {
                cnt = 1;
            }

            str = arr[i];

            if (cnt == 2 && !list.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
