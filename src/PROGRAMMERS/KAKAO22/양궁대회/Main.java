package PROGRAMMERS.KAKAO22.양궁대회;

class Main {
    static int[] lion;
    static int[] current;
    static int total;

    static int max = -1000;
    static int[] result = { -1 };


    public int[] solution(int n, int[] info) {
        lion = new int[11];
        current = info;
        total = n;

        shot(0, 0);

        return result;
    }

    static void shot(int to, int cnt) {
        if (cnt == total) {
            int lScore = 0;
            int aScore = 0;
            for (int i=0; i<11; i++) {
                //어피치가 점수 받을 수 있는 경우
                if (lion[i] <= current[i]) {
                    if (current[i] != 0) {
                        aScore += 10 - i;
                    }
                }
                else {
                    lScore += 10 - i;
                }
            }
            if ((lScore-aScore) <= 0) return;

            if (max < lScore - aScore) {
                result = lion.clone();
                max = lScore - aScore;
            }
            else if(max == (lScore - aScore)) {
                for (int i=10; i>=0; i--) {
                    if((lion[i] < result[i])) {
                        break;
                    }
                    else if(lion[i] > result[i]){
                        result = lion.clone();
                        max = lScore - aScore;
                        break;
                    }
                }
            }

            return;
        }

        if (to > 10) return;



        for (int i=0; i<11; i++) {
            lion[to] += i;
            //불필요하게 많이 쐈을 떄
            if (lion[to] > current[to]+1) {
                lion[to] -= i;
                return;
            }
            shot(to+1, cnt+i);
            lion[to] -= i;
        }

    }
}