# 🔣 알고리즘 : Divide and Conquer

큰 문제를 풀 수 있는 작은 문제들의 합으로 해결하는 알고리즘<br>
Dynamic Programming 과 간혹 헷갈릴 수 있다.<br>
부분해를 다음 단계에 이용하는(Memoization) DP 와 달리 DC는 각각의 부분해가 다음 단계에 영향을 미치지 않는다.

## ❗ 알고리즘

3번째 Divide and Conquer 문제<br>
색종이 만들기 문제와 유사하며 출력 부분만 조금 추가되었다.<br>
핵심은 재귀 전 후의 동작을 잘 생각하여서 메소드를 기준으로 위 아래에 어떤 코드가 올지에 대한 고민이 필요하다.

## ❗ 알고리즘 외

String -> char : charAt()<br>
char -> int : Character.getNumericalValue()

## 🙂 정리

몫은 수평선에서 왼쪽으로 붙는다는 것 항상 생각<br>
그림을 그려서 값의 범위를 살펴보자<br>
좌표계에서 박스 공간 또한 점으로 한번 바라보자