import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        for (int i = 1; i <= num; i *= 10) {
            cnt += (num - i + 1);
        }
        System.out.println(cnt);
    }
}
