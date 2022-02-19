# 🔣 알고리즘 : BackTracking

DFS와 매우 유사한 BackTracking 은 Graph/Tree 공간에서 탐색하는 DFS 와 Problem Space 에서 탐색을 해나간다는 점에서
구분이 된다.<br>
상태를 저장하고 목적함수와 부합하는 해를 찾아나가는 방식

## ❗ 알고리즘

BackTracking에서 요구하는 조건을 잘 활용했다고 생각하는 문제<br>
재귀함수를 호출할 때, 상태를 저장하는 sum 과 현재 depth 를 나타내는 start 를 두고 문제를 해결했다.<br>
특정한 상태일 때 count 를 올리고, depth 를 통해 종료조건을 만들었다.<br>
nC1 nC2 ... nCn 의 경우의 수를 모두 고려해야했는데, 재귀함수 호출 전 후로 상태를 저장/삭제 함으로써 브루투포스 알고리즘을 구현했다.

## ❗ 알고리즘 외

없음.

## 🙂 정리

brute force, BackTracking 연관관계 생각 !

 
