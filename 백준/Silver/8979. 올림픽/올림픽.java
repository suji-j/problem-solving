import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Medal {
        int num, gold, silver, bronze, rank;

        public Medal(int num, int gold, int silver, int bronze, int rank) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Medal> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new Medal(num, gold, silver, bronze, 0));
        }

        list.sort((o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                }
                return o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        });

        int ranking = 1;
        int preGold = list.get(0).gold, preSilver = list.get(0).silver, preBronze = list.get(0).bronze;
        list.get(0).rank = ranking;

        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (list.get(i).gold == preGold && list.get(i).silver == preSilver && list.get(i).bronze == preBronze) {
                list.get(i).rank = ranking;
                cnt++;
            } else {
                ranking += cnt;
                list.get(i).rank = ranking;
                preGold = list.get(i).gold;
                preSilver = list.get(i).silver;
                preBronze = list.get(i).bronze;
                cnt = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (list.get(i).num == k) {
                bw.write(String.valueOf(list.get(i).rank));
                break;
            }
        }
        bw.close();
    }
}
