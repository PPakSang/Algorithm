# 🔣 알고리즘 : BFS (Breadth First Search)

DFS(Depth First Search)와 구분되는 탐색법 중 하나로, 선택한 노드의 인접한 노드를 먼저 탐색하는 전략이다.<br>
탐색법 중에서도 시간이 조금 걸리더라도 어쨌든 모든 경우를 탐색해봐야하는 경우에 자주 사용된다.<br>
최단 거리 찾기, 최단 시간(토마토 문제) 도출 등에 사용된다.<br><br>

반대로, DFS는 일단 빨리 길(목적노드)을 찾는게 우선인 경우에 사용

## ❗ 알고리즘

이분 그래프에 대한 이해가 선행되어야 하는 문제였다.  
  
이분 그래프는 연결된 두 노드의 집합이 항상 달라야한다는 것이다.  

  
최초 접근은 그룹이 없는 상태에서, 한 노드의 그룹을 1로 설정하고 그 노드와 연결된 노드를 다른 그룹으로 설정하는 방식으로 진행한다.

연결된 노드는 다시 Q 에 넣어서 연결된 노드의 연결된 노드를 탐색할 수 있도록 하고 만약 탐색하다가 이미 그룹이 있는 노드가
  
같은 그룹의 노드와 연결되어 있는 것이 발견된다면 NO 를 출력한다.



## ❗ 알고리즘 외

연결 그래프가 보장되면 하나의 노드만을 Queue 에 넣고도 모든 노드를 탐색 가능하다.
  
단절 그래프가 존재할 시에는 모든 정점을 탐색하면서 방문 여부를 확인해야 한다.

## 🙂 정리

처음에는 노드 1 을 q 에 넣고 탐색을 진행했는데, 그렇게 되면 한 연결 그래프 만을 탐색할 수 있다  
  
단절 그래프(disconnected graph) 가 존재하는 상황에서는 모든 노드를 체크하며 다 방문이 되었는지 확인해야한다

