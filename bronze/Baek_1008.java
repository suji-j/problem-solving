package BaekJoon;
//1008

import java.util.Scanner;

public class Baek_1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double div = num1 / num2;
        System.out.printf("%.9f", div);

    }
}
