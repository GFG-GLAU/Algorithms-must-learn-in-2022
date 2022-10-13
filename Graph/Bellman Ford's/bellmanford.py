class Graph:



    def __init__(self, vertices):

        self.M = vertices   # Total number of vertices in the graph

        self.graph = []     # Array of edges



    # Add edges

    def add_edge(self, a, b, c):

        self.graph.append([a, b, c])



    # Print the solution

    def print_solution(self, distance):

        print("Vertex Distance from Source")

        for k in range(self.M):

            print("{0}\t\t{1}".format(k, distance[k]))



    def bellman_ford(self, src):



        distance = [float("Inf")] * self.M

        distance[src] = 0



        for _ in range(self.M - 1):

            for a, b, c in self.graph:

                if distance[a] != float("Inf") and distance[a] + c < distance[b]:

                    distance[b] = distance[a] + c



        for a, b, c in self.graph:

            if distance[a] != float("Inf") and distance[a] + c < distance[b]:

                print("Graph contains negative weight cycle")

                return



        self.print_solution(distance)



g = Graph(5)

g.add_edge(0, 1, 2)

g.add_edge(0, 2, 4)

g.add_edge(1, 3, 2)

g.add_edge(2, 4, 3)

g.add_edge(2, 3, 4)

g.add_edge(4, 3, -5)



g.bellman_ford(0)
