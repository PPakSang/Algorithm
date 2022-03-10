# 🔣 알고리즘 : Dynamic Programming

동적계획법(Dynamic Programming)의 구현 방식에는 두가지가 있다.
1. Top-Down 방식의 **재귀(recursion)** 마지막에서 처음으로
2. Bottom-Up 방식의 **반복(iteration)** 처음에서 마지막으로

두 가지 방식에서 **반복되는 문제는 한 번만 푼다** 를 추가하면 Dynamic Programming 의 요구 조건을 만족시킨다.<br>
반복되는 문제를 한 번만 풀기 위해서는 Memoization(배열, 리스트, 집합 등을 사용하여)을 구현 하여야 한다.


## ❗ 알고리즘

LCS (Longest Common Subsequence), 가장 긴 증가하는 부분수열 문제와 공통.<br>
어떻게 insertion 의 횟수를 최소로 할 수 있을까 생각이 필요했다.<br>
insertion sorting 에서 **이미 정렬되어 있는 수** 를 파악하면 몇 번의 추가적인 insertion 이 더 필요한지 파악할 수 있다.<br>
이미 정렬되어 있는 수 는 다른 말로 가장 긴 증가하는 부분수열을 구하는 것과 마찬가지이기 때문에 LCS 방식으로 문제를 해결했다.

## ❗ 알고리즘 외

없음

## 🙂 정리

없음