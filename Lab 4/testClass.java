import java.util.ArrayList;

@SuppressWarnings("unused")
public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[][] testGraph = {{0,	80,	0,	25,	60,	0,	0,	0,	0,	0}, 
							 {80,	0,	25,	0,	0,	0,	21,	0,	0,	0},
							 {0,	25,	0,	40,	0,	20,	23,	0,	0,	0},
							 {25,	0,	40,	0,	55,	35,	0,	0,	0,	0},
							 {60,	0,	0,	55,	0,	0,	0,	0,	0,	0},
							 {0,	0,	20,	35,	0,	0,	0,	20,	0,	0},
							 {0,	21,	23,	0,	0,	0,	0,	25,	10,	0},
							 {0,	0,	0,	0,	0,	20,	25,	0,	0,	12},
							 {0,	0,	0,	0,	0,	0,	10,	0,	0,	30},
							 {0,	0,	0,	0,	0,	0,	0,	12,	30,	0}};
		
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(testGraph);
		int testVertexU = 6;
		int testVertexV = 3;
		graph.printAdjMatrix();
		System.out.println("*****************************************************************");
		System.out.println("Edge Set:" + graph.edgeSet());
		System.out.println("*****************************************************************");
		System.out.println("Directed Graph: "+graph.isDirected());
		System.out.println("numVertices:"+graph.numVertices()+"\tnumEdges:"+graph.numEdges());
		System.out.println("This graph is a complete graph:"+graph.isComplete());
		System.out.println("TestVertex:"+testVertexV+"\tinDegree:"+graph.inDegree(testVertexV)+"\toutDegree:"+graph.outDegree(testVertexV));
		System.out.print("TestVertex:"+testVertexV+"\tneighborList:");
		System.out.println(graph.neighbors(testVertexV));
		System.out.println("*****************************************************************");
		graph.insertEdge(testVertexU, testVertexV, 10);
		System.out.println("Vertex:"+testVertexU+" and Vertex:" +testVertexV+" are neighbors:" + graph.isNeighbors(testVertexU, testVertexV));
		System.out.println("Successfully insert an edge: " + graph.insertEdge(testVertexU, testVertexV, 10));
		graph.removeEdge(testVertexU,testVertexV);
		System.out.println("Vertex:"+testVertexU+" and Vertex:" +testVertexV+" are neighbors:" + graph.isNeighbors(testVertexU, testVertexV));
		System.out.println("Successfully remove an edge: " + graph.removeEdge(testVertexU,testVertexV));
		System.out.println("*****************************************************************");
		System.out.println("BFS Graph Traversal:");
		System.out.println(graph.BFS(0));
		//or System.out.println(graph.DFS());
		
		System.out.println("*****************************************************************");
		graph.printAdjMatrix();
	}

}
