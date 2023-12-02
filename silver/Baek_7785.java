package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine());
        Map<String, Integer> companyLog = new HashMap<>();

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                companyLog.put(name, i);
            } else {
                companyLog.remove(name);
            }
        }

        String[] nameList = new String[companyLog.size()];
        int index = 0;
        for (String name : companyLog.keySet()) {
            nameList[index] = name;
            index++;
        }

        nameList = Arrays.stream(nameList).sorted(Collections.reverseOrder()).toArray(String[]::new);
        for (String s : nameList) {
            System.out.println(s);
        }
    }
}
