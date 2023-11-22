import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int count = 0;
        int minLength = 64;
        int stickLength = 0;

        if (X == 64) {
            count = 1;
        } else {
            while (stickLength != X) {
                if (stickLength + minLength / 2 > X) {
                    minLength /= 2;
                } else {
                    minLength /= 2;
                    stickLength += minLength;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
