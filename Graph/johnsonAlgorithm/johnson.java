// Java program for the above approach
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	private static class Neighbour {
		int destination;
		int weight;

		Neighbour(int destination, int weight)
		{
			this.destination = destination;
			this.weight = weight;
		}
	}

	private int vertices;
	private final ArrayList<ArrayList<Neighbour> >
		adjacencyList;

	// On using the below constructor,
	// edges must be added manually
	// to the graph using addEdge()
	public Graph(int vertices)
	{
		this.vertices = vertices;

		adjacencyList = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++)
			adjacencyList.add(new ArrayList<>());
	}

	// On using the below constructor,
	// edges will be added automatically
	// to the graph using the adjacency matrix
	public Graph(int vertices, int[][] adjacencyMatrix)
	{
		this(vertices);

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (adjacencyMatrix[i][j] != 0)
					addEdge(i, j, adjacencyMatrix[i][j]);
			}
		}
	}

	public void addEdge(int source, int destination,
						int weight)
	{
		adjacencyList.get(source).add(
			new Neighbour(destination, weight));
	}

	// Time complexity of this
	// implementation of dijkstra is O(V^2).
	public int[] dijkstra(int source)
	{
		boolean[] isVisited = new boolean[vertices];
		int[] distance = new int[vertices];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance = 0;

		for (int vertex = 0; vertex < vertices; vertex++) {
			int minDistanceVertex = findMinDistanceVertex(
				distance, isVisited);
			isVisited[minDistanceVertex] = true;

			for (Neighbour neighbour :
				adjacencyList.get(minDistanceVertex)) {
				int destination = neighbour.destination;
				int weight = neighbour.weight;

				if (!isVisited[destination]
					&& distance[minDistanceVertex] + weight
						< distance[destination])
					distance[destination]
						= distance[minDistanceVertex]
						+ weight;
			}
		}

		return distance;
	}

	// Method used by `int[] dijkstra(int)`
	private int findMinDistanceVertex(int[] distance,
									boolean[] isVisited)
	{
		int minIndex = -1,
			minDistance = Integer.MAX_VALUE;

		for (int vertex = 0; vertex < vertices; vertex++) {
			if (!isVisited[vertex]
				&& distance[vertex] <= minDistance) {
				minDistance = distance[vertex];
				minIndex = vertex;
			}
		}

		return minIndex;
	}

	// Returns null if
	// negative weight cycle is detected
	public int[] bellmanford(int source)
	{
		int[] distance = new int[vertices];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance = 0;

		for (int i = 0; i < vertices - 1; i++) {
			for (int currentVertex = 0;
				currentVertex < vertices;
				currentVertex++) {
				for (Neighbour neighbour :
					adjacencyList.get(currentVertex)) {
					if (distance[currentVertex]
							!= Integer.MAX_VALUE
						&& distance[currentVertex]
								+ neighbour.weight
							< distance
									[neighbour
										.destination]) {
						distance[neighbour.destination]
							= distance[currentVertex]
							+ neighbour.weight;
					}
				}
			}
		}

		for (int currentVertex = 0;
			currentVertex < vertices; currentVertex++) {
			for (Neighbour neighbour :
				adjacencyList.get(currentVertex)) {
				if (distance[currentVertex]
						!= Integer.MAX_VALUE
					&& distance[currentVertex]
							+ neighbour.weight
						< distance[neighbour
										.destination])
					return null;
			}
		}

		return distance;
	}

	// Returns null if negative
	// weight cycle is detected
	public int[][] johnsons()
	{
		// Add a new vertex q to the original graph,
		// connected by zero-weight edges to
		// all the other vertices of the graph

		this.vertices++;
		adjacencyList.add(new ArrayList<>());
		for (int i = 0; i < vertices - 1; i++)
			adjacencyList.get(vertices - 1)
				.add(new Neighbour(i, 0));

		// Use bellman ford with the new vertex q
		// as source, to find for each vertex v
		// the minimum weight h(v) of a path
		// from q to v.
		// If this step detects a negative cycle,
		// the algorithm is terminated.

		int[] h = bellmanford(vertices - 1);
		if (h == null)
			return null;

		// Re-weight the edges of the original graph using the
		// values computed by the Bellman-Ford algorithm.
		// w'(u, v) = w(u, v) + h(u) - h(v).

		for (int u = 0; u < vertices; u++) {
			ArrayList<Neighbour> neighbours
				= adjacencyList.get(u);

			for (Neighbour neighbour : neighbours) {
				int v = neighbour.destination;
				int w = neighbour.weight;

				// new weight
				neighbour.weight = w + h[u] - h[v];
			}
		}

		// Step 4: Remove edge q and apply Dijkstra
		// from each node s to every other vertex
		// in the re-weighted graph

		adjacencyList.remove(vertices - 1);
		vertices--;

		int[][] distances = new int[vertices][];

		for (int s = 0; s < vertices; s++)
			distances[s] = dijkstra(s);

		// Compute the distance in the original graph
		// by adding h[v] - h[u] to the
		// distance returned by dijkstra

		for (int u = 0; u < vertices; u++) {
			for (int v = 0; v < vertices; v++) {

				// If no edge exist, continue
				if (distances[u][v] == Integer.MAX_VALUE)
					continue;

				distances[u][v] += (h[v] - h[u]);
			}
		}

		return distances;
	}

	// Driver Code
	public static void main(String[] args)
	{
		final int vertices = 4;
		final int[][] matrix = { { 0, 0, -2, 0 },
								{ 4, 0, 3, 0 },
								{ 0, 0, 0, 2 },
								{ 0, -1, 0, 0 } };

		// Initialization
		Graph graph = new Graph(vertices, matrix);

		// Function Call
		int[][] distances = graph.johnsons();

		if (distances == null) {
			System.out.println(
				"Negative weight cycle detected.");
			return;
		}

		// The code fragment below outputs
		// an formatted distance matrix.
		// Its first row and first
		// column represent vertices
		System.out.println("Distance matrix:");

		System.out.print(" \t");
		for (int i = 0; i < vertices; i++)
			System.out.printf("%3d\t", i);

		for (int i = 0; i < vertices; i++) {
			System.out.println();
			System.out.printf("%3d\t", i);
			for (int j = 0; j < vertices; j++) {
				if (distances[i][j] == Integer.MAX_VALUE)
					System.out.print(" X\t");
				else
					System.out.printf("%3d\t",
									distances[i][j]);
			}
		}
	}
}
