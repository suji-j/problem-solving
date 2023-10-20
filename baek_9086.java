import java.io.*;

public class baek_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            System.out.print(str.charAt(0));
            System.out.println(str.charAt(str.length() - 1));
        }

    }
}
