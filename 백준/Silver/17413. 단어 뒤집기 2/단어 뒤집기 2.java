import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();

        String str = br.readLine();
        char[] ca = str.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '<') {
                if (s.empty()) {
                    while (ca[i] != '>') {
                        System.out.print(ca[i]);
                        i++;
                    }
                    System.out.print(ca[i]);
                } else {
                    while (!s.empty()) {
                        System.out.print(s.pop());
                    }
                    i--;
                }
            } else if (ca[i] == ' ') {
                while (!s.empty()) {
                    System.out.print(s.pop());
                }
                System.out.print(" ");
            } else {
                s.push(ca[i]);
            }
        }

        if (!s.empty()) {
            while (!s.empty()) {
                System.out.print(s.pop());
            }
        }
        System.out.print(" ");
    }
}