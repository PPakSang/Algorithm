# 🔣 알고리즘 : BFS, BackTracking

DFS와 매우 유사한 BackTracking 은 Graph/Tree 공간에서 탐색하는 DFS 와 Problem Space 에서 탐색을 해나간다는 점에서
구분이 된다.<br>
상태를 저장하고 목적함수와 부합하는 해를 찾아나가는 방식<br><br>

DFS(Depth First Search)와 구분되는 탐색법 중 하나로, 선택한 노드의 인접한 노드를 먼저 탐색하는 전략이다.<br>
탐색법 중에서도 시간이 조금 걸리더라도 어쨌든 모든 경우를 탐색해봐야하는 경우에 자주 사용된다.<br>
최단 거리 찾기, 최단 시간(토마토 문제) 도출 등에 사용된다.<br><br>

반대로, DFS는 일단 빨리 길(목적노드)을 찾는게 우선인 경우에 사용

## ❗ 알고리즘

Combination, BackTracking, BFS 3종세트 문제<br>
Combination 은 1차원 배열의 재귀로 구현가능<br>
BackTracking 조건 Y>3 또는 cnt == 7 일 때 각각 return, BFS 를 수행한다<br><br>
BFS 의 목적은 뽑은 숫자 7개가 인접한지에 관한 판단을 하기위함 이고<br>
BFS 를 수행하기 위해서는 방문 상태를 저장할 배열, Queue 가 필요 => Dir 에 따른 조건 판별


## ❗ 알고리즘 외

2차원 배열을 1차원으로 바라보는 법<br>
ex) 5x5 배열 arr[num/5][num%5] 으로 표현하면<br>
0 1 2 3 4<br>
5 6 7 8 9 의 인덱스를 붙여서 <br><br> 

0 1 2 3 4 5 6 7 8 9 의 1차원 배열로 생각할 수 있다.

## 🙂 정리

시간이 지나고 꼭 다시 풀어봐야할 문제


 
