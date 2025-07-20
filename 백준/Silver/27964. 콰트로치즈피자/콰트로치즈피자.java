import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = st.nextToken();
            if (str.length() >= 6 && str.substring(str.length() - 6).equals("Cheese")) {
                set.add(str);
            }
        }

        bw.write(set.size() >= 4 ? "yummy" : "sad");
        bw.close();
    }
}
