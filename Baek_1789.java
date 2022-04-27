package BaekJoon;

import java.io.IOException;
import java.util.Scanner;

//1789-수들의 합
public class Baek_1789 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        long num = scan.nextLong();
        long sum = 0;
        long cnt = 0;

        while (true) {
            cnt++;
            sum += cnt;
            if (sum > num){
                break;
            }
        }

        System.out.println(cnt - 1);
        scan.close();
    }
}
