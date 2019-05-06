
public class Edge {
	private int startVertex;
	private int endVertex;
	
	public Edge(int startVertex, int endVertex) {
		super();
		this.startVertex = startVertex;
		this.endVertex = endVertex;
	}
	
	public int getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(int startVertex) {
		this.startVertex = startVertex;
	}
	public int getEndVertex() {
		return endVertex;
	}
	public void setEndVertex(int endVertex) {
		this.endVertex = endVertex;
	}

	@Override
	public String toString() {
		return "Edge[" + startVertex + " -> " + endVertex + "]";
	}
	

}
