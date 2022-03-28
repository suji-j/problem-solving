package BaekJoon;
//11720
import java.util.Scanner;
public class Baek_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();;
        int sum = 0;

        for (int i = 0; i<num; i++){
            sum += str.charAt(i) - 48;
        }

        System.out.println(sum);
        sc.close();
    }
}
