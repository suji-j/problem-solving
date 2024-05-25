class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int cnt = 0;
        String binary = "";
        
        while(!s.equals("1")) {
            String text = s.replace("0", "");
            zero += s.length() - text.length();
            int one = text.length();
            binary = Integer.toBinaryString(one);
            s = binary;
            answer[0]++;
        }
        answer[1] = zero;
        return answer;
    }
}