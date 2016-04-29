 /* File: Player.java
 * Authors: Damian Liu (daliu@bu.edu), Tynan Seltzer (tseltzer@bu.edu)
 * Date: 4/26/16
 * Purpose: This is HW 10, Problem B
 */

// Need size and moves implemented in graph

public class Player{
  private final int D =4;
  private final int Inf = 1000000;
public Move move(Graph G) {
 int max = -Inf; Move best=null;
 for(int i=0;i<G.size();++i) {
   for(int j=i+1;j<G.size();++j){
     if (!G.isEdge(i,j)){
       G.addEdge(i,j,-1);
     
     Move m= new Move(i,j);    
 int val = minMax( G, 1, -Inf, Inf );
 
 if(val >= max) { 
    best = m; 
   max = val;
 }
 
 G.removeEdge(i,j);
   }
 }
 }
 System.out.println("moved");
 System.out.println(max);
 if (best==null)
   System.out.println("lost");
 System.out.println(best.source);
 System.out.println(best.target);
 return best; }
private int eval(Graph G){
  int score = 0;
       
        for(int i = 0; i < G.size(); i++){
          if(G.degree(i, 1) == 1)
            score += 1;
          if (G.degree(i, 1) > 1)
            score += 5;
          if(G.degree(i, 1) == 1)
            score += 1;
          if(G.degree(i, -1) > 1)
            score -= 5;
        }
        if(G.isCycleOfLength(3, 1))
          score = Inf;
        if(G.isCycleOfLength(3, -1))
          score = -Inf;
        return score;

}
    

int minMax(Graph G, int depth, int alpha, int beta ) {
 // int alpha;
  //int beta;
 if(!G.moves() || depth == D)
 return eval(G); // stop searching and return eval
 else if( depth%2==0 ) {
 int val = -Inf;
 for(int i=0;i<G.size();++i) {
   for(int j=i+1;j<G.size();++j) {
     if (!G.isEdge(i,j)){
 alpha = Math.max(alpha, val); // update alpha with max so far
 if(beta < alpha) break; // terminate loop
 G. addEdge(i,j,-1);
 val = Math.max(val, minMax( G, depth+1, alpha, beta ));
 G.removeEdge(i,j);
     }}}                         
 return val;
 } else { // is a min node
 int val = Inf;
 for(int i=0;i<G.size();++i) {
   for(int j=i+1;j<G.size();++j) {
     if (!G.isEdge(i,j)){
 beta = Math.min(beta, val); // update beta with min so far
 if(beta < alpha) break; // terminate loop
 G.addEdge(i,j,1);
 System.out.println("here");
 val = Math.min(val, minMax( G, depth+1, alpha, beta ) );
 G.removeEdge(i,j);
 }
         }
}
return val; 
}
 
} } 