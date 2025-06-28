import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String[] sounds = br.readLine().split(" ");
            ArrayList<String> crying = new ArrayList<>();

            while (true) {
                String line = br.readLine();
                if (line.equals("what does the fox say?")) break;

                String[] part = line.split(" ");
                crying.add(part[2]);
            }

            for (String sound : sounds) {
                if (!crying.contains(sound)) {
                    bw.write(sound + " ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}
