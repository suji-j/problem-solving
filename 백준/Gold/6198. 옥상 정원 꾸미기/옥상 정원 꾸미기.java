import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] map = new int[n];
        for (int i = 0; i < n ; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;
        Stack<Integer> garden = new Stack<>();
        for (int i = 0; i < n; i++) {
            int h = map[i];

            while (!garden.isEmpty() && garden.peek() <= h) {
                garden.pop();
            }
            result += garden.size();
            garden.add(h);
        }

        System.out.println(result);
    }
}
