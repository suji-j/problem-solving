import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int index = 2;
        s.push(arr[1]);

        while (true) {
            if (!s.isEmpty() && s.peek() == cnt) {
                int pop = s.pop();
                cnt = pop + 1;
                continue;
            }

            if (!s.contains(arr[index])) {
                s.push(arr[index]);
                index += 1;
            }

            if (index == N + 1) break;
        }


        for (int i = cnt; i <= N; i++) {
            if (s.peek() == i) {
                s.pop();
            } else {
                System.out.println("Sad");
                break;
            }
        }

        if (s.isEmpty()) System.out.println("Nice");
    }
}