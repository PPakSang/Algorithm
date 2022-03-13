# 🔣 알고리즘 : Dynamic Programming

동적계획법(Dynamic Programming)의 구현 방식에는 두가지가 있다.
1. Top-Down 방식의 **재귀(recursion)** 마지막에서 처음으로
2. Bottom-Up 방식의 **반복(iteration)** 처음에서 마지막으로

두 가지 방식에서 **반복되는 문제는 한 번만 푼다** 를 추가하면 Dynamic Programming 의 요구 조건을 만족시킨다.<br>
반복되는 문제를 한 번만 풀기 위해서는 Memoization(배열, 리스트, 집합 등을 사용하여)을 구현 하여야 한다.


## ❗ 알고리즘

배낭의 무게와 물건의 종류를 dp 표로 만들어서 해결할 수 있는 문제<br>
임의의 무게 K 일 때 물건 별로 넣을 수 있는지 여부를 체크하고 한 물건을 넣었다면 남은 공간에 넣을 수 있던<br>
최대 가치를 찾으면 된다.<br>

## ❗ 알고리즘 외

동적 계획법에서 bottom-up 방식을 채택한다면 배열은 0자리는 out of range 방어를 위해 비워두자<br>
top-down 방식을 채택한다면 dp 는 Integer 로 두고 null 체크를 하자

## 🙂 정리

없음
