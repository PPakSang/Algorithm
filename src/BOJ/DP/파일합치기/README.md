# 🔣 알고리즘 : Dynamic Programming

동적계획법(Dynamic Programming)의 구현 방식에는 두가지가 있다.
1. Top-Down 방식의 **재귀(recursion)** 마지막에서 처음으로
2. Bottom-Up 방식의 **반복(iteration)** 처음에서 마지막으로

두 가지 방식에서 **반복되는 문제는 한 번만 푼다** 를 추가하면 Dynamic Programming 의 요구 조건을 만족시킨다.<br>
반복되는 문제를 한 번만 풀기 위해서는 Memoization(배열, 리스트, 집합 등을 사용하여)을 구현 하여야 한다.


## ❗ 알고리즘

dp[1][5] 를 첫 번째 페이지에서 부터 5번째 페이지의 합의 최소로 정의하면

dp[1][j] 는 dp[1][1] + dp[2][5], dp[1][2] + dp[3][5] ... 의 최소값이 될 것이다  
  
근데 점화식이 어느 상황에서도 커버가 되려면 bottom-up 을 할 때 전략을 잘 세워야하는데,  
  
가령 다짜고짜 dp[2][5] 를 구하려면 dp[2][2] 도 있어야하고(basic case) dp[2][3] 도 있어야하고, 커버가 불가능하다

다시 잘 살펴보면 n+1 개씩 파일을 묶는 항들은 n 이하개씩 파일을 묶을 때의 항만 필요로 하기 때문에 bottom-up 의 기준은 파일을 묶는 항이 돼야하고  
  
n개씩 묶는다고 했으면 파일을 n 개 단위로 잘라가면서 각 세트마다 점화식을 수행해주면 해결이 될 것이다

## ❗ 알고리즘 외

점화식의 선행되는 항이 커버가 되는지 신경쓰면서 점화식을 완성해야한다

## 🙂 정리

없음