import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i += 10) {
            bw.write(str.substring(i, Math.min(i + 10, str.length())) + "\n");
        }

        bw.close();
    }
}
