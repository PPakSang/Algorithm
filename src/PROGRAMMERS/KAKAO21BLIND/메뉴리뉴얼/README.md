## ☑️Map.getOrDefault(Key, DefaultValue)

기본적으로 map.get() 에서 값이 없으면 null 을 반환한다  
이를 이용해서 조건문을 짜도 되지만 getOrDefault 를 써보도록 노력  
간단한 연산 (유무만 필요할 때)을 수행할 때는 merge(Key, Object, BiFunction) 으로 이전 value 랑 새로 들어온 value 랑 연산 가능  
  
map.put 으로 중복 key 에 넣으면 덮어씌워진다  

## ☑️String.toCharArray() 후 Arrays.sort()

String 자체는 연산하기 매우 불편한 자료형 toCharArray 로 바꾼 후 sort 하자  

## ☑️new Comparator<Object>() { compare  구현}

sorted 보조  

## ☑️String.compareTo

사전순 정렬이 가능하다  

## ☑️List.stream().sorted(Comparator)

String 을 정렬할 때는 PriorityQueue 에 데이터 추가하거나 Collections.sort 사용  


  
  
부족하고 또 부족하고 또 부족하다. 열심히하자