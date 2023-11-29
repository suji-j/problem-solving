package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baek_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            numList.add(Integer.parseInt(br.readLine()));
            sum += numList.get(i);
        }
        Collections.sort(numList);

        System.out.println(sum / 5);
        System.out.println(numList.get(2));
    }
}
