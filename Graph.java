/* File: Graph.java
 * Authors: Damian Liu (daliu@bu.edu), Tynan Seltzer (tseltzer@bu.edu)
 * Date: 4/26/16
 * Purpose: This is HW 10, Problem B
 */


public class Graph { 
  
  private static final int N = 6;
  
  private static int[][] B = new int[N][N];       // 0 = no edge; 1 = red edge; -1 = blue edge
  
  public Graph(int Q) {                           // a constructor for a instance of the class with N vertices 
    B = new int[Q][Q];
  }
  
  public void addEdge(int u, int v, int w) {       // add an edge from vertex u to v with value w (which in this hw will be  only 0, -1, or 1)
    B[u][v] = w;
    B[v][u] = w;
  }
  
  public void removeEdge(int u, int v) {          // remove the edge from u to v and the (duplicate) edge from v to u
    B[u][v] = 0;
    B[v][u] = 0;
  }
  
  public int getEdge(int u, int v) {              // return the value (-1, 0, or 1) of the edge that goes from u to v
    return B[u][v];
  }
  
  public boolean isEdge(int u, int v) {           // return true or false depending on whether there is an edge (of either color) from u to v
    return (B[u][v] == 1) || (B[u][v] == -1);
  }
  
  public int degree(int v) {                      // return the number of edges of either color connected to vertex v
    int count = 0;
    for (int i = 0; i < N; ++i) {
      if (isEdge(i,v))
        ++count;
    }
    return count;
  }
  
  public int degree(int v, int w) {               // return the number of edges of color w connected to vertex v
    int count = 0;
    for (int i = 0; i < N; ++i) {
      if (getEdge(i,v) == w);
      ++count;
    }
    return count;
  }
  
  public void printEdges() {                      // print out the edge matrix, as shown above; this is only for debugging
    String out = "      0   1   2   3   4   5\n";
    String [] axisLabels = {"0: ", "1: ", "2: ", "3: ", "4: ", "5: "};
    for (int i = 0; i < 6; ++i) {
      out += axisLabels[i];
      for (int j = 0; j < 6; ++j) {
        out += "  ";
        if (getEdge(i,j) == 0)
          out += "  ";
        else
          out += getEdge(i,j);
      }
      out += "\n";
    }
    System.out.println(out);
  }
  
  public boolean isCycleOfLength(int n, int w) {  // return true iff there is a cycle of length n among edges of color w 
    for (int i = 0; i < 6; ++i) {
      for (int j = (i+1) % 6; j != i; j = (j+1) % 6) { // j should be the second vertex
        if (isEdge(i, j)) {
          int color = getEdge(i,j);
          for (int k = (j+1) % 6; k != j; k = (k+1) % 6) {
            if (((isEdge(j, k) && k != i) && (isEdge(i,k))) && ((getEdge(j,k) == color) && (getEdge(i,k) == color)))
              return true;
          }
        }
      }
    }
    return false;
  }
  
  public int size(){
    return N;
  }
  public boolean moves(){
    int num=N*(N-1);
    int sum=0;
    for(int i=0;i<N;++i){
      sum+=degree(i);
    }
    if (sum==num)
      return false;
    else
      return true;
  }
  public static void main(String[] args) {
    
    Graph G = new Graph(N);
    
    G.printEdges();
    
    G.addEdge(0, 1, -1);
    G.addEdge(1,4,-1);
    G.addEdge(4,0,-1);
    
    G.printEdges();
    
    System.out.println(G.isEdge(4,1));
    System.out.println(G.isEdge(0,1));
    System.out.println(G.isEdge(4,0));
    
    System.out.println(G.isCycleOfLength(3, -1));
    
  }
  
}
