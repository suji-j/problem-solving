package BaekJoon;
//10872
import java.util.Scanner;
public class Baek_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int mulNum = 1;

        for (int i=num ; i>0 ; i--){
            mulNum = mulNum * i;
        }

        System.out.println(mulNum);
    }
}
