# 🔣 소수개수 구하기

진수 변경 -> 문자열 파싱 -> 소수 판별의 역시 간단한 문제<br>
문제를 해석하고, 위 과정을 손쉽게 하는 방법을 생각하느라 Solution2_2 추가 작성

## ☑️진수 변경
n 을 k 진수로 변경하고자하면<br>
n 을 k로 나눈 나머지, n/k 을 k로 나눈 나머지 ... 를 거꾸로 본 것이 해당 진수의 숫자이다

## ☑️소수 판별
에라토스테네스의-체 를 사용하였고 기본적인 로직은 아래와같다<br>
2부터 Math.sqrt(num) 까지 하나씩 나눠보면서 나머지가 0인 수가 있으면 소수가 아님 

## ☑️StringBuilder sb = new StringBuilder();

진수 변경을 위해서 사용을 하였으며, 문자열 추가가 잦고, reverse 가 필요했기 때문에 사용하였음

## ☑️List<Integer> list = new ArrayList<>(List.of / Arrays.asList)

List 를 생성하는 여러가지 방법

## ☑️split() / forEach()
split 을 통해서 0 delimeter 로 parsing 을 수행하였고, 빈 문자열이 존재할 수 있으므로 조건문을 거쳐 Arrays.stream(T[]).forEach 문을 통해서 새로운 ArrayList에 값을 넣었음






