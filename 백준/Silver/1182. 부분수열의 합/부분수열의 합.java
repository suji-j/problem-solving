import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static List<Integer> result, p;
    static int n, s, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        answer = 0;

        num = new int[n];
        result = new ArrayList<>();
        p = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        back(0);
        System.out.println(calculate());
    }

    static int calculate() {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) == s) {
                answer++;
            }
        }
        return answer;
    }

    static void back(int start) {
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            sum += result.get(i);

            if (i == result.size() - 1) {
                p.add(sum);
            }
        }

        for (int i = start; i < n; i++) {
            result.add(num[i]);
            back(i + 1);
            result.remove(result.size() - 1);
        }
    }
}
