import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int six = 666;
        int count = 0;
        String sixStr;

        while (true) {
            sixStr = String.valueOf(six);
            if (sixStr.contains("666")) {
                count++;
            }
            if (count == n) {
                six = Integer.parseInt(sixStr);
                break;
            }
            six++;
        }
        System.out.println(six);
    }
}