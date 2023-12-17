package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        Set<String> combination = new HashSet<>();

        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j <= number.length(); j++) {
                combination.add(number.substring(i, j));
            }
        }

        System.out.println(combination.size());
    }
}
