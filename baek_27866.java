import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String arr[] = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr = str.split("");
        }

        int index = Integer.parseInt(br.readLine());

        System.out.println(arr[index-1]);
    }
}
