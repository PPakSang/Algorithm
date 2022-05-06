package QBuild.BinarySearch;

public class UpperBound {

    String[] sample;

    void solveUpperBound(int std) {
        int start = 0;
        // length 로 잡아야하는 이유는 Edge Case 방어하기 위해서, 모든 배열 값이 기준 값 보다 작을 경우
        int end = sample.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > std) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
    }
}

