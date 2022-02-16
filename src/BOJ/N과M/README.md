# 🔣 알고리즘 : BackTracking

DFS와 매우 유사한 BackTracking 은 Graph/Tree 공간에서 탐색하는 DFS 와 Problem Space 에서 탐색을 해나간다는 점에서
구분이 된다.<br>
상태를 저장하고 목적함수와 부합하는 해를 찾아나가는 방식

## ❗ 알고리즘

써보지 않았던 객체(StringBuilder, LinkedHashSet)를 써볼 수 있는 문제.<br>
큰 로직은 brute force 로 숫자 n개를 고르고, 중복을 제거하는 방식이다.<br>
확인해야할 조건은 숫자가 n개 뽑히고, 썼던 숫자는 또 못쓰게 하는 것<br>
각각 cnt / visited[] 로 처리<br><br>

cnt == s 일 때 StringBuilder 로 답이 될 문자열을 만들어 주었다.<br>
문자열을 만들고는 LinkedHashSet 에 추가해줌으로써 중복을 제거했다.

## ❗ 알고리즘 외

문자열 추가/삭제

1. String.concat()<br>
-String 객체를 이용해 문자열을 붙이는 방식, 내부적으로 기존의 객체에 붙이는 방식이 아니라 새로운 객체를 생성하는 방식을 사용하므로 성능이나 속도 측면에서 비효율적임

2. String 과 +연산자<br>
-jdk 1.5 이전에는 내부적으로 concat() 메소드를 이용해 새로운 인스턴스를 생성해 새로운 객체를 반환하도록 했지만
이후에는 StringBuilder 객체로 변환 -> append() -> toString() 의 방식으로 바뀌었다.
3. StringBuilder / StringBuffer
-이 두가지 객체와 String 객체와의 가장 큰 차이점은 mutable 하다는 것이다.<br>
String 객체는 내부적으로 새로운 객체를 생성하는 반면 StringBuilder 와 StringBuffer 는 하나의 객체로 문자열을 추가, 삭제가 가능하다.<br>
다만 StringBuffer 는 multi-thread 상황에서 thread-safe 를 보장(동기화 보장)하기 때문에 속도 측면으로만 보면 StringBuilder 가 조금 더 빠르다.<br><br>

추가적으로 이번 문제에서 내부적으로 StringBuilder 를 생성하는 + 연산자와 같이 StringBuilder 객체를 매 시행시마다 생성하는 방식으로 구현해서
각각의 방식으로 구현했을 때 속도의 차이가 있을까 궁금해서 따로 제출해보니 결과는 StringBuilder 객체를 매번 생성하는게 + 연산자보다 빨랐다.<br>
유의미한 시간 차이인지는 모르겠지만 아무래도 + 연산자가 결국에는 해석되는 과정에서 소요되는 시간이 있으니 조금 더 느릴거라는 결론을 내렸다.<br>

![img.png](img.png) <br>

## 🙂 정리

String 을 다루는건 항상 잘 기억하자
 
