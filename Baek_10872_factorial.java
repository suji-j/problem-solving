package BaekJoon;
//10872
import java.util.Scanner;
public class Baek_10872_factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num  = sc.nextInt();
        System.out.println(fact(num));
    }

    public static int fact(int a){
        if (a <= 1){
            return 1;
        }
        else{
            return fact(a - 1) * a;
        }
    }
}
