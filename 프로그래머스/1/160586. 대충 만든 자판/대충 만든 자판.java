class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int idx = 0; idx < targets.length; idx++) {
            String str = targets[idx];

            for (int i = 0; i < str.length(); i++) {
                int cnt = 101;
                for (int j = 0; j < keymap.length; j++) {
                    int index = keymap[j].indexOf(str.charAt(i));
                    if (index != -1) {
                        if (index < cnt) {
                            cnt = index;
                        }
                    }
                }

                if (cnt == 101) {
                    answer[idx] = -1;
                    break;
                } else {
                    answer[idx] += cnt + 1;
                }
            }
        }
        
        return answer;
    }
}