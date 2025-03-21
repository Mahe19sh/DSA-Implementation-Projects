#Graphs are a way to model how different things are connected to one another.
#Usually represent graph with hash table where key is a vertex and values is a list of its neighbors.

#Starting with BFS algorithm 
from collections import defaultdict
import deque from collectionsdefaultdict,  # type: ignore
import heapq

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
parents = {} #stores each node and associated parent of the node.
processed = [] #A list to store processed nodes to avoid revisit.

def Dijkstras():
    node = find_lowest_cost_node(costs)
    while node:
        cost = costs[node]
        neighbors = graph[node]
        for n in neighbors:
            new_cost = cost + neighbors[n]
            if costs[n] > new_cost:
                costs[n] = new_cost
                parents[n] = node
        processed.append(node)
        node = find_lowest_cost_node(costs)

def find_lowest_cost_node(costs):
    lowest_cost = float("inf")
    lowest_cost_node = None
    for node in costs:
        cost = costs[node]
        if cost < lowest_cost and node not in processed:
            lowest_cost = cost
            lowest_cost_node = node
    return lowest_cost_node

"""
Limitations of Dijkstra:
    1) Works only for DAG's(Direct Acyclic Graphs)
    2) Cannot work for negitive weighted edges and cycles(Bellman-Ford).
    3) Single source shortest path not works for all pairs.

Drawbacks of above code version:
    1) find_lowest_cost_node() does a linear search through all nodes → O(n) time. Over all iterations, it's O(n²) for dense graphs.
    2) Checking if a node is in processed list is O(n) time. Using a set makes it O(1).
    3) No Priority Queue/Heap: In real-world scenarios with large graphs, this will become very slow due to the repeated linear searches.
    4) For reusability, it’s better to pass the graph and other params into the function.
"""
#Real world Dijkstra code implementation.

def Dijkstra(graph, start):
    heap = [(0, start)]
    distances = {node:float("inf") for node in graph}
    distances[start] = 0
    while heap:
        curr_distance, node = heapq.heappop(heap)
        for neighbor, weight in graph[node].items():
            new_distance = curr_distance + weight
            if new_distance < distances[neighbor]:
                distances[neighbor] = new_distance
                heapq.heappush(heap, (new_distance, neighbor))
    return distances


#Some example LeetCode problems where Dijkstras applicable.

# 1) LeetCode_743 : Network Delay Time.
"""
    Problem Statement: You are given a network of n nodes, labeled from 1 to n. 
    You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
    We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
"""
#Code Solution:

def networkDelayTime(times,n,k) -> int:
    graph = defaultdict(dict)
    for u, v, w in times:
        graph[u][v] = w       
    heap = [(0,k)]
    distances = {node:float("inf") for node in range(1, n+1)}
    distances[k] = 0
    while heap:
        curr_dist, node = heapq.heappop(heap)
        if curr_dist > distances[node]:
            continue
        for neighbor, distance in graph[node].items():
            new_distance = distance + curr_dist
            if new_distance < distances[neighbor]:
                distances[neighbor] = new_distance
                heapq.heappush(heap, (new_distance, neighbor))
    max_time = max(distances.values())
    return max_time if max_time < float("inf") else -1


        









        
