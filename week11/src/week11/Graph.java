package week11;

public interface Graph {
	public void init();
	public int length();
	public void setVertex(String[] nodes);
	public void addVertex(String node);
	public void setEdge(int v1, int v2, int weight);
	public void setEdge(String v1, String v2, int weight);
	public void setVisited(int v);
	public boolean ifVisited(int v);
	public void clearWalk();
	public void walk(String order);
	public void DFS(int s); //depth first
	public void BFS(int s); //breath first
	public void display(); //display basic info
	public void displayEnum(); //display enumeration of the vertices
	public void topSort(); //topological sorting: to-be-implemented
	
		/** Initialize the graph
		@param n The number of vertices */
		public void Init(int n);
		/** @return The number of vertices */
		public int n();
		/** @return The current number of edges */
		public int e();
		/** @return v¡¯s first neighbor */
		public int first(int v);
		/** @return v¡¯s next neighbor after w */
		public int next(int v, int w);
		/** Set the weight for an edge
		@param i,j The vertices
		@param wght Edge weight */
		
		/** Delete an edge
		@param i,j The vertices */
		public void delEdge(int i, int j);
		/** Determine if an edge is in the graph
		@param i,j The vertices
		@return true if edge i,j has non-zero weight */
		public boolean isEdge(int i, int j);
		/** @return The weight of edge i,j, or zero
		@param i,j The vertices */
		public int weight(int i, int j);
		/** Set the mark value for a vertex
		@param v The vertex
		@param val The value to set */
		public void setMark(int v, int val);
		/** Get the mark value for a vertex
		@param v The vertex
		@return The value of the mark */
		public int getMark(int v);
}