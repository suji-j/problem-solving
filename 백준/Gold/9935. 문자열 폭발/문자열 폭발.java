import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String explosion = br.readLine();
        int expSize = explosion.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            int sbSize = sb.length();

            if (sb.length() >= expSize && sb.substring(sbSize - expSize, sbSize).equals(explosion)) {
                sb.delete(sbSize-expSize, sbSize);
            }
        }

        if (sb.length() == 0) {
            bw.write("FRULA");
        } else {
            bw.write(sb.toString());
        }

        bw.close();
        br.close();
    }
}
