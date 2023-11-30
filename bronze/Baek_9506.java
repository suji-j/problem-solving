package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            List<Integer> divisor = new ArrayList<>();
            int sum = 0;
            int num = Integer.parseInt(br.readLine());
            if (num == -1) {
                break;
            }

            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    divisor.add(i);
                    sum += i;
                }
            }

            if (num == sum) {
                System.out.print(num + " = ");
                for (int i = 0; i < divisor.size(); i++) {
                    if (i == divisor.size()-1) {
                        System.out.println(divisor.get(i));
                    } else {
                        System.out.print(divisor.get(i) + " + ");
                    }
                }
            } else {
                System.out.println(num + " is NOT perfect.");
            }
        }
    }
}
