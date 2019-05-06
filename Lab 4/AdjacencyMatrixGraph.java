import java.util.*;

public class AdjacencyMatrixGraph {
	// private double[][] adjacencyMatrix;
	private double adjacencyMatrix[][];
	private int vertices;

	// initialize the graph based on a user given adjacency matrix
	public AdjacencyMatrixGraph(double[][] adjMatrix) {
		int v = adjMatrix.length;// creates public to pass to private
		vertices = v;
		adjacencyMatrix = new double[v][v];
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				adjacencyMatrix[i][j] = adjMatrix[i][j];
			}
		}
	}

	// check if the graph is a directed graph
	public boolean isDirected() {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices - i; j++) {
				if (adjacencyMatrix[i][j] != adjacencyMatrix[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	// get the number of numVertices
	public int numVertices() {
		return vertices;
	}

	// get the number of edges
	public int numEdges() {
		int count = 0;
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (adjacencyMatrix[i][j] > 0) {
					count++;
				}
			}
		}
		return count;
	} /*
		 * else { for (int i = 0; i < numVertices; i++) { for (int j = 0; j <
		 * numVertices - i; j++) { if (adjacencyMatrix[i][j] > 0) { count++; } } } }
		 */

	// check if a graph is complete
	public boolean isComplete() {
		for (int i = 0; i < vertices; i++) {
			if (outDegree(i) < vertices - 1)
				return false;
		}
		return true;
	}

	// get the number of out degree for the vertex whose index is v
	public int outDegree(int v) {
		int degree = 0;
		for (int i = 0; i < vertices; i++) {
			if (adjacencyMatrix[v][i] > 0)
				degree++;
		}
		return degree;
	}

	// get the number of in degree for the vertex whose index is v
	public int inDegree(int v) {
		int degree = 0;
		for (int i = 0; i < vertices; i++) {
			if (adjacencyMatrix[i][v] > 0)
				degree++;
		}
		return degree;
	}

	// get the list of neighbor for the vertex whose index is v
	public ArrayList<Integer> neighbors(int v) {
		ArrayList<Integer> N = new ArrayList<>();
		Integer x;
		for (int i = 0; i < vertices; i++) {
			if (adjacencyMatrix[v][i] > 0) {
				x = new Integer(i);
				N.add(x);
			}

		}
		return N;
	}

	// get the set of edges
	public ArrayList<Edge> edgeSet() {
		ArrayList<Edge> edgeSet = new ArrayList<>();
		Edge node;
		/* if (isDirected()) { */
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (adjacencyMatrix[i][j] > 0) {
					node = new Edge(i, j);
					edgeSet.add(node);
				}
			}
		}
		return edgeSet;
	} /*
		 * else { for (int i = 0; i < numVertices; i++) { for (int j = 0; j <
		 * numVertices - i; j++) { if (adjacencyMatrix[i][j] > 0) { x = new Edge(i, j);
		 * E.add(x); } }
		 * 
		 * } } return E; }
		 */

	/*
	 * public ArrayList<Edge> edgeSet2() { ArrayList<Edge> E = new ArrayList<>();
	 * Edge x; if (isDirected()) { for (int i = 0; i < numVertices; i++) { for (int
	 * j = 0; j < numVertices; j++) { if (A[i][j] > 0) { x = new Edge(i, j);
	 * E.add(x); } } }} }
	 */

	// return true if vertex u and v are neighbors
	public boolean isNeighbors(int u, int v) {
		if (adjacencyMatrix[u][v] > 0)// greater than 0 means they are neighbors
			return true;
		else if (adjacencyMatrix[v][u] > 0)
			return true;
		return false;
	}

	// insert an edge between two numVertices, return false if there is an edge
	// between
	// them already
	public boolean insertEdge(int u, int v, double weight) {
		if (u >= vertices || v >= vertices)// numVertices must be on graph
			return false;
		else if (adjacencyMatrix[u][v] > 0)// must not be an edge already
			return false;
		else
			adjacencyMatrix[u][v] = weight;
		System.out.println("Edge inserted into graph on vertex " + u + " and vertex " + v);
		return true;
	}

	// remove an edge between two numVertices, return false if there is no edge
	// between
	// them
	public boolean removeEdge(int u, int v) {
		if (u >= vertices || v >= vertices)// checks same as add method
			return false;
		else if (adjacencyMatrix[u][v] == 0)// checks if not an edge cannot remove
			return false;
		else
			adjacencyMatrix[u][v] = 0;// set edge equal to 0 which removes it
		System.out.println("Edge removed on vertex " + u + " and vertex " + v);
		return true;
	}

	// get the traversal sequence of the graph by using BFS and keep the sequence in
	// an ArrayList
	public ArrayList<Edge> BFS(int start) {
		ArrayList<Edge> BFS = new ArrayList<>();
		boolean visited[] = new boolean[vertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		Edge x;
		Integer v;// wraps int value

		visited[start] = true;
		queue.add(start);
		while (queue.size() != 0) {
			v = queue.poll();
			for (int i = 0; i < vertices; i++) {
				if (adjacencyMatrix[v][i] > 0 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					x = new Edge(v, i);
					BFS.add(x);
				}
			}
		}
		return BFS;
	}
	// or DFS()
	/*
	 * get the traversal sequence of the graph by using DFS and keep the sequence in
	 * an ArrayList
	 * 
	 * public ArrayList<Edge> DFS() {
	 * 
	 * }
	 */

	// obtain the minimum spanning tree on a undirected graph, return null if the
	// graph is directed
	// public ArrayList<Edge> MST(int start){

	// }

	// print out the adjacency matrix if the number of numVertices in the graph is
	// less
	// than 20
	public void printAdjMatrix() {
		if (adjacencyMatrix.length < 20) {
			for (int i = 0; i < adjacencyMatrix.length; i++) {// loops through array
				for (int j = 0; j < adjacencyMatrix.length; j++) {
					System.out.print(adjacencyMatrix[i][j] + "\t");
				}
				System.out.println(" ");// creates new row after each i loop
			}

		} else {
			System.out.println("adjacencyMatrix is greater than 20, cannot print");
		}
	}
	// true false false false use 3 three removing edge = false
}
