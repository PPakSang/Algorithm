package QBuild.BinarySearch;

import java.util.*;

//~~이상
public class LowerBound {

    String[] sample;

    <T> void solveLowerBound(List<T> list, int std) {
        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if ((int)list.get(mid) >= std) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
    }


    void solveLowerBound(int std) {
        int start = 0;
        // length 로 잡아야하는 이유는 Edge Case 방어하기 위해서, 모든 배열 값이 기준 값 보다 작을 경우
        int end = sample.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (mid >= std) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
    }
}
