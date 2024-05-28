class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            String str = "";
            String[] arr1Binary = checkLength(Integer.toBinaryString(arr1[i]), n).split("");
            String[] arr2Binary = checkLength(Integer.toBinaryString(arr2[i]), n).split("");

            for (int j = 0; j < n; j++) {
                if (arr1Binary[j].equals("1") || arr2Binary[j].equals("1")) {
                    str += "1";
                    continue;
                }
                str += "0";
            }
            answer[idx++] = str.replace("0", " ").replace("1", "#");
        }
        return answer;
    }
    
    public String checkLength(String str, int n) {
        if (str.length() != n) {
            int cnt = n - str.length();
            String addZero = "";
        
            for (int i = 0; i < cnt; i++) {
                addZero += "0";
            }
            return addZero + str;
        }
        return str;
    }
}