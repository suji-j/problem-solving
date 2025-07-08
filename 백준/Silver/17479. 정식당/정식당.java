import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int basicPrice = 0, specialPrice = 0, serviceCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<String, String> category = new HashMap<>();
        Map<String, Integer> menuPrice = new HashMap<>();

        for (int i = 0; i < a; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            String menu = input.nextToken();
            int price = Integer.parseInt(input.nextToken());

            category.put(menu, "basic");
            menuPrice.put(menu, price);
        }

        for (int i = 0; i < b; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            String menu = input.nextToken();
            int price = Integer.parseInt(input.nextToken());

            category.put(menu, "special");
            menuPrice.put(menu, price);
        }

        for (int i = 0; i < c; i++) {
            String menu = br.readLine();
            category.put(menu, "service");
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String menu = br.readLine();

            if (category.get(menu).equals("basic")) {
                basicPrice += menuPrice.get(menu);
            } else if (category.get(menu).equals("special")) {
                specialPrice += menuPrice.get(menu);
            } else {
                serviceCnt++;
            }
        }


        if (serviceCnt > 1) {
            bw.write("No");
        } else if (serviceCnt == 1) {
            if (specialPrice > 0) {
                if (basicPrice >= 20000 && basicPrice + specialPrice >= 50000) {
                    bw.write("Okay");
                } else {
                    bw.write("No");
                }
            } else {
                if (basicPrice >= 50000) {
                    bw.write("Okay");
                } else {
                    bw.write("No");
                }
            }
        } else {
            if (specialPrice > 0) {
                if (basicPrice >= 20000) {
                    bw.write("Okay");
                } else {
                    bw.write("No");
                }
            } else {
                bw.write("Okay");
            }
        }

        bw.close();
    }
}
