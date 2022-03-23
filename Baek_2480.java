package BaekJoon;

import java.util.Scanner;

public class Baek_2480 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int price = 0;

        if (a==b && b==c){
            price = 10000 + (a * 1000);
        } else if (a==b || b==c || c==a){
            if (a==b && b!=c){
                price = 1000 + (a * 100);
            } else if (b==c && c!=a){
                price = 1000 + (b * 100);
            } else if (c==a && a!=b){
                price = 1000 + (c * 100);
            }
        } else if (a!=b && b!=c && c!=a){
            if (a>b && ((b>c) || (c>b && a>c))){
                price = a * 100;
            } else if (b>c && ((c>a) || (c<a && b>a) )) {
                price = b * 100;
            } else if (c>a && ((a>b) || (a<b && b<c))){
                price = c * 100;
            }
        }

        System.out.println(price);

        scan.close();
    }
}
