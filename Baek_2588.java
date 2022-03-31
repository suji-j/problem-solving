package BaekJoon;
//2588
import java.util.Scanner;
public class Baek_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int mulA = (a%10) + ((a%100)-(a%10)) +(a-((a%100)));

        int num3 = (b%10) * mulA;
        int num4 = ((b%100)-(b%10)) * mulA;
        int num5 = (b-(b%100)) * mulA;

        System.out.print(num3 + "\n" + num4/10 + "\n" + num5/100 + "\n");
        System.out.println(num3 + num4 + num5);
    }
}
