class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            if (food[i] > 1) {
                for (int cnt = 1; cnt <= food[i] / 2; cnt++) {
                    sb.append(i);
                }
            }
        }
        
        String answer = sb.toString() + "0";
        String reversedStr = sb.reverse().toString();
        answer += reversedStr;
        
        return answer;
    }
}