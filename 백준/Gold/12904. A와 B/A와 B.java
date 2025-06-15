import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
            } else {
                t = t.substring(0, t.length() - 1);
                t = new StringBuilder(t).reverse().toString();
            }
        }

        bw.write(s.equals(t) ? "1" : "0");
        bw.close();
    }
}
