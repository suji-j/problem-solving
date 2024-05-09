import java.util.Set;
import java.util.HashSet;

class Solution {
    static boolean[] isUsed;
    static Set<Integer> set;
    static String[] arr;
    static int length;

    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.split("");
        length = arr.length;
        set = new HashSet<>();
        isUsed = new boolean[length + 1];

        permu(0, "");

        for (int i : set) {
            if (prime(i) && i > 1) answer++;
        }

        return answer;
    }

    public void permu(int index, String sum) {
        if (!sum.isEmpty()) {
            set.add(Integer.parseInt(sum));
        }

        for (int i = 0; i < length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permu(index + 1, sum + arr[i]);
                isUsed[i] = false;
            }
        }
    }

    public boolean prime(int n) {
        int cnt = 0;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}