# 🔣 알고리즘 : BFS (Breadth First Search)

DFS(Depth First Search)와 구분되는 탐색법 중 하나로, 선택한 노드의 인접한 노드를 먼저 탐색하는 전략이다.<br>
탐색법 중에서도 시간이 조금 걸리더라도 어쨌든 모든 경우를 탐색해봐야하는 경우에 자주 사용된다.<br>
최단 거리 찾기, 최단 시간(토마토 문제) 도출 등에 사용된다.<br><br>

반대로, DFS는 일단 빨리 길(목적노드)을 찾는게 우선인 경우에 사용

## ❗ 알고리즘

BFS 문제에 조건 판별이 아주아주 빡셌던 문제<br>
완전탐색 최악의 경우 400 * 400 정도로 완전 탐색을 하라고 나온 문제란걸 알 수 있었다.<br>
매 완전 탐색마다 최적의 먹이 위치를 찾고, 찾았으면 먹으러 가면 된다.<br>
distance 를 체크하고 visited 를 같이 체크했어야하는데 distance 가 있다는건 visited 라는 의미를 나타낸다.<br>


## ❗ 알고리즘 외

Integer.MAX_VALUE : 32비트 int 최대값

## 🙂 정리

생각한걸 코드로 옮기는데 시간이 너무 오래 걸린다. 더 열심히 해야겠다.


