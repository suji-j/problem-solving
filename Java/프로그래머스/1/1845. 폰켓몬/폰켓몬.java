import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = 0;
        
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i]) && list.size() != nums.length / 2) {
                list.add(nums[i]);
            }
            
            answer = list.size();
        }
        return answer;
    }
}