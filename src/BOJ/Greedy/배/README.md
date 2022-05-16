# 🔣 알고리즘 : Greedy

탐욕스럽고 욕심많은 전략을 택한다 해서 Greedy 하다고 불리는 이 알고리즘은<br>
나에게 당장 가장 많은 이득을 가져다 줄 것으로 예상되는 행동을 취하는 방식이다. ~~팃포텟?~~<br>
알고리즘을 학습하면서 느낀점은 수학적인 문항을 풀 때 자주나오고, 그렇기 때문에 조건식을 잘 만들어야한다.

## ❗ 알고리즘

당일날 가장 많이(그리디하게) 일할 수 있는 방법은 모든 크레인에게 상자를 할당하는 것이다.  
상자를 할당하돼 무거운 상자부터 무거운 것을 들 수 있는 크레인에게 나눠줘야한다.

## ❗ 알고리즘 외

wrapper class 만 Comparator 사용 가능  
primitive type 은 실제 값이 stack 영역에 저장됨  
반대로 wrapper class 는 실제 값은 heap 에 저장되고 stack 영역에는 참조 주소가 저장됨  
  
primitive type 메모리 사용량은 흔히 아는 type 별 데이터 크기  
reference type 은 포인터 개념이라 그런지 128 bits 사용함 (Long, Double 196bits)  

Array -> Collection : Arrays.stream(ArrayObj).toList() 한 것을 Collection 생성자에 넣기  
new LinkedList<>(...)
  
## 🙂 정리

없음 


