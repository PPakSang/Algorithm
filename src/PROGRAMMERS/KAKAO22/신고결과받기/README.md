# 🔣 신고결과받기

데이터구조를 설정하는 것이 핵심인 문항<br>
로직은 문자열 파싱 -> 조건문 의 구조로 단순한 편

## ☑️Map<Key, Value> = new HashMap<>();

Key - Value 구조로 이루어진 Map을 이용해서 데이터 구조를 만들었다<br>
신고당한사람 - 신고자들.... (1)<br>
신고한사람 - 알람.... (2)<br><br>

## ☑️split String(with StringTokenizer) 
"신고한사람 신고당한사람" 의 String 을 StringTokenizer 를 사용하여 key value 로 나누었다<br>

## ☑️HashSet
신고자들은 중복이 안된다 하였으므로 HashSet 으로 구성하였다.<br>
Map 에서 HashSet은 get-add 가 가능함

## ☑️Map-Integer
var.put(key, var.get(...)+1) 의 방식으로 값 업데이트 가능



