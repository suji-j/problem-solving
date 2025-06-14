import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> set = new HashSet<>();

        int cur = 1, ans = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            if (!set.contains(name)) {
                cur++;
                set.add(name);
            }

            if (game.equals("Y") && cur == 2) {
                ans++;
                cur = 1;
            } else if (game.equals("F") && cur == 3) {
                ans++;
                cur = 1;
            } else if (game.equals("O") && cur == 4){
                ans++;
                cur = 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
