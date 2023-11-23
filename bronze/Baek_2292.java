package BaekJoon;
//2292
import java.util.Scanner;
public class Baek_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 1;
        int bee = 1;

        if (num <= 1){
            System.out.println(count);
        }
        else{
            while (bee < num){
                bee += (count * 6);
                count++;
            }
            System.out.println(count);
        }
    }
}
