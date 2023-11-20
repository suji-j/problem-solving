import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2720 {
    static int quarter = 25;
    static int dime = 10;
    static int nickel = 5;
    static int penny = 1;
    static String blank = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int cnt = 0; cnt < T; cnt++) {
            int quarterCnt = 0;
            int dimeCnt = 0;
            int nickelCnt = 0;
            int pennyCnt = 0;
            int C = Integer.parseInt(br.readLine());

            if (C >= quarter) {
                quarterCnt = C / quarter;
                C = C % quarter;
            }

            if (C >= dime) {
                dimeCnt = C / dime;
                C = C % dime;
            }

            if (C >= nickel) {
                nickelCnt = C / nickel;
                C = C % nickel;
            }

            if (C >= penny) {
                pennyCnt = C / penny;
                C = C % penny;
            }
            sb.append(quarterCnt + blank + dimeCnt + blank + nickelCnt + blank + pennyCnt + "\n");
        }
        System.out.println(sb);
    }
}
