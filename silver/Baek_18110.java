import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int except = (int) Math.round((n * 15) / 100.0);

        int sum = 0;
        for (int i = except; i < list.size() - except; i++) {
            sum += list.get(i);
        }

        System.out.println(Math.round((float) sum / (n - (except * 2))));
    }
}