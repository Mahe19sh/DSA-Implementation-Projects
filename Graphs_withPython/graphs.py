#Graphs are a way to model how different things are connected to one another.
#Usually represent graph with hash table where key is a vertex and values is a list of its neighbors.

#Starting with BFS algorithm 
import deque from collections # type: ignore

graph = {}
visited = [] #list to ensure no duplicates allowed to explore again and again.

def BFS(graph):
    q = deque()
    while q:
        node = q.popleft()
        if node not in visited:
            print(node, " ")
        for neighbor in graph[node]:
            q.add(neighbor)
            visited.append(neighbor)
#Doesn't work for weighted graphs(Solution: Dijkstra's Algorithm)
#Memory intensive for large graphs
#Cannot handle dynamic graphs(graphs where edges changes over time)

#Let's go with DFS algorithm in both iterative and recursive approaches.
#Recursive DFS
def dfs_recu(graph, visited, node):
    if node in visited:
        return 
    print(node," ")
    visited.append(node)

    for neighbor in graph[node]:
        dfs_recu(graph, visited, neighbor)

#Iterative DFS
def dfs_iter(graph):
    stack = []
    while stack:
        node = stack.pop()
        if node not in visited:
            print(node, " ")
        for neighbor in graph[node]:
            stack.append(node)
            visited.append(node)

#Dijkstra's Algorithm
"""
4 steps of Dijkstra's algorithm:
    1) Find the cheapest node
    2) update the costs of neighbors of the node
    3) Repeat unitil you have done for every node in graph
    4) calculate the final path.
"""
#Code Implementation

graph_dijkstra = {} #Has many hashtables inside which stores node neighbors and their weights.
costs = {} #stores nodes and their weights.
parents = {} #






        
