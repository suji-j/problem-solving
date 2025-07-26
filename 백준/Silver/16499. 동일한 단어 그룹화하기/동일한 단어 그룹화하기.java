import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] word = str.toCharArray();

            Arrays.sort(word);
            String wordStr = new String(word);
            set.add(wordStr);
        }

        bw.write(String.valueOf(set.size()));
        bw.close();
    }
}
