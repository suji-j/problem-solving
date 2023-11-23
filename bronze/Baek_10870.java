package BaekJoon;
//10870
import java.util.Scanner;
public class Baek_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(Fibo(num));
    }

    public static int Fibo(int a){
        if (a <= 1){
            return a;
        }
        else{
            return (Fibo(a-1) + Fibo(a-2));
        }
    }
}
