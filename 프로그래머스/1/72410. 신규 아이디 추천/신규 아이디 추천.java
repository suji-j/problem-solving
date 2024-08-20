import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

class Solution {
    public String solution(String new_id) {
        // 1. 소문자 만들기
        new_id = new_id.toLowerCase();

        // 2. 특정 문자 제외하고 제거하기
        for (int i = 0; i < new_id.length(); i++) {
            if (!(isVaild(new_id.charAt(i)))) {
                String ch = String.valueOf(new_id.charAt(i));
                new_id = new_id.replace(ch, "");
                i--;
            }
        }

        // 3. 마침표 두개는 한 개로 만들기
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        // 4. 마침표가 처음이나 끝이면 제거
        if (new_id.length() > 0) {
            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1);
            }
        }
        if (new_id.length() > 0) {
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 5. 빈 문자열이면 "a" 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6. 16자 이상이면 첫 15개 문자만
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 7. 2자 이하라면 마지막 문자를 길이 3이 될 때까지 반복
        if (new_id.length() < 3) {
            while (new_id.length() != 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        return new_id;
    }
    
    public boolean isVaild(char ch) {
        return (ch == 45) || (ch == 46) || (ch == 95) || (48 <= ch && ch <= 57) || (97 <= ch && ch <= 122);
    }
}