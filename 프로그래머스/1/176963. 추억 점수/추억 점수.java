import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int idx = 0;
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    answer[idx] += map.get(photo[i][j]);
                }
            }
            idx++;
        }
        
        return answer;
    }
}