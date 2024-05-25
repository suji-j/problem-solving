import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        String[] arr = str.split("");
        List<Integer> list = new ArrayList<>();
        
        for (String st : arr) {
            list.add(Integer.parseInt(st));
        }
        
        for (int num : list) {
            answer += num;
        }

        return answer;
    }
}