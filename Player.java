 /* File: Player.java
 * Authors: Damian Liu (daliu@bu.edu), Tynan Seltzer (tseltzer@bu.edu)
 * Date: 4/26/16
 * Purpose: This is HW 10, Problem B
 */

// Need size and moves implemented in graph

public class Player{
  private int final D =7;
  private int final Inf = 1000000;
public Move move(Graph G) {
 int max = -Inf; Move best;
 for(int i=0;i<G.size();++i) {
   for(int j=i+1;i<G.size();++i){
     if (G.isEdge(i,j)){
       G.addEdge(i,j,-1);
     }
     move m= new Move(i,j);    
 int val = minMax( G, 1, -Inf, Inf );
 if(val > max) { best = m; max = val };
 }
 G.removeEdge(i,j);
 }
 return best; }
private int eval(Graph G){
  int score=0;
  for (int i=0;i<G.size();++i){
    if (G.degree(j,-1)>1)
      score+=20;
    if (G.degree(j,1)>1)
      score-=19;
    if (G.degree(j,-1)>2)
      score+=200;
    if (G.degree(j,1)>2)
      score-=190;
  }
  if (G.isOfCycleLength(3,1)){
    return 100000;
  }
  else if (G.isOfCycleLength(3,-1)){
    return -100000;
  }
  else
    return score;
}
    

int minMax(Graph G, int depth, int alpha, int beta ) {
  int alpha;
  int beta;
 if(!G.moves() || depth == D)
 return eval(G); // stop searching and return eval
 else if( depth%2==0 ) {
 int val = -100000;
 for(int i=0;i<G.size();++i) {
   for(int j=i+1;i<G.size();++i) {
     if (!G.isEdge(i,j){
 alpha = max(alpha, val); // update alpha with max so far
 if(beta < alpha) break; // terminate loop
 G. addEdge(i,j,-1);
 val = max(val, minMax( G, depth+1, alpha, beta ));
 G.removeEdge(i,j);
     }}}                         
 return val;
 } else { // is a min node
 int val = 100000;
 for(int i=0;i<G.size();++i) {
   for(int j=i+1;i<G.size();++i) {
     if (!G.isEdge(i,j){
 beta = min(beta, val); // update beta with min so far
 if(beta < alpha) break; // terminate loop
 G.addEdge(i,j,1);
 val = min(val, minMax( c, depth+1, alpha, beta ) );
 G.removeEdge(i,j);
 }
         }
}
}
 return val;
} } 