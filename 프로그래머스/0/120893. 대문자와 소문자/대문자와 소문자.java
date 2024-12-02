class Solution {
    public String solution(String my_string) {
        char[] charArr = my_string.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] > 64 && charArr[i] < 91) {
                charArr[i] += 32;
            } else {
                charArr[i] -= 32;
            }
        }
        String answer = String.valueOf(charArr);
        return answer;
    }
}