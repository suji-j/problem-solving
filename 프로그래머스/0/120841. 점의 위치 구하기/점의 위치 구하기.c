#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// dot_len은 배열 dot의 길이입니다.
int solution(int dot[], size_t dot_len) {
    for (int i = 0; i < dot_len; i++) {
        if (dot[0] > 0 && dot[1] > 0) {
            return 1;
        } else if (dot[0] < 0 && dot[1] > 0) {
            return 2;
        } else if (dot[0] < 0 && dot[0] < 0) {
            return 3;
        } else {
            return 4;
        }
    }
}