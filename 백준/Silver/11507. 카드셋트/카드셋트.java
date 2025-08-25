import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String card = br.readLine();
        String[] cardArr = new String[card.length() / 3];

        int idx = 0;
        for (int i = 0; i <= card.length() - 3; i += 3) {
            cardArr[idx++] = card.substring(i, i + 3);
        }

        HashMap<Character, Integer> cardMap = new LinkedHashMap<>();
        cardMap.put('P', 13);
        cardMap.put('K', 13);
        cardMap.put('H', 13);
        cardMap.put('T', 13);

        HashSet<String> set = new HashSet<>();
        boolean greska = false;
        for (String str : cardArr) {
            char ch = str.charAt(0);
            int num = Integer.parseInt(str.substring(1));

            if (!set.contains(str)) {
                set.add(str);
                cardMap.put(ch, cardMap.get(ch) - 1);
            } else {
                greska = true;
                break;
            }
        }

        if (greska) {
            bw.write("GRESKA");
        } else {
            for (char ch : cardMap.keySet()) {
                bw.write(cardMap.get(ch) + " ");
            }
        }
        bw.close();
    }
}
