import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Mauricio Toro
 * @version 1
 * Student: Sarah Henao
 * Date: August 1, 2018
 * Implemented a method that recieved a Digraph and returns the node with the most neighbors.
 * This method works for both data structures: Adjacency lists and matrices.
 */
public class DigraphAlgorithms
{
        private static int minVertex (int [] dist, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i=0; i<dist.length; i++) {
           if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
        }
        return y;
     }
  
    
  static int [] dijsktra(Digraph dg, int source)
  {
          final int [] dist = new int [dg.size()];  // shortest known distance from "s"
         final int [] pred = new int [dg.size()];  // preceeding node in path
         final boolean [] visited = new boolean [dg.size()]; // all false initially
   
         for (int i=0; i<dist.length; i++) {
           dist[i] = Integer.MAX_VALUE; //Infinity
       }
        dist[source] = 0;
  
        for (int i=0; i<dist.length; i++) {
           final int next = minVertex (dist, visited);
           visited[next] = true;
  
           // The shortest path to next is dist[next] and via pred[next].
  
           final ArrayList<Integer> n = dg.getSuccessors (next); 
           for (int j=0; j<n.size(); j++) {
              final int v = n.get(j);
              final int d = dist[next] + dg.getWeight(next,v);
              if (dist[v] > d) {
                 dist[v] = d;
                 pred[v] = next;
              }
           }
        }
        return pred;  // (ignore pred[s]==0!)
  }
  
  
       public static ArrayList getPath (int [] pred, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
       int x = e;
        while (x!=s) {
           path.add (0, x);
           x = pred[x];
        }
        path.add (0, s);
        return path;
     }
       
       // New method for finding the vertex with the most successors in a directed graph.
       public static int mostSuccessors(Digraph dg) {
    	   int resVertex = 0;
    	   int maxSucc = 0;
    	   
    	   for (int i = 0; i < dg.size; i++) {
    		   int n = dg.getSuccessors(i).size();
    		   if (n > maxSucc) {
    			   resVertex = i;
    			   maxSucc = n;
    		   }
    	   }
    	   return resVertex;
       }
       
       public static 
       
  
 // Código para dibujar el grafo en GraphViz
 // Recomiendo www.webgraphviz.com/
     public static void dibujarGrafo(Digraph g)
     {
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++)
        {
           ArrayList<Integer> lista = g.getSuccessors(i);
           for (int j = 0; j < lista.size(); j++)
             System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\""+ g.getWeight(i,lista.get(j)) +"\"];");
        }
        System.out.println("}");
     }
     
 
 
 public static void main(String[] args)
 {
     DigraphAL dgal = new DigraphAL(5);
     dgal.addArc(0,1,10);
     dgal.addArc(0,2,3);
     dgal.addArc(1,2,1);
     dgal.addArc(1,3,2);
     dgal.addArc(2,1,4);
     dgal.addArc(2,3,8);
     dgal.addArc(2,4,2);
     dgal.addArc(3,4,7);
     dgal.addArc(4,3,9);
     
     System.out.println(getPath(dijsktra(dgal,0),0,3));
     
     DigraphAM dgam = new DigraphAM(5);
     dgam.addArc(0,1,10);
     dgam.addArc(0,2,3);
     dgam.addArc(1,2,1);
     dgam.addArc(1,3,2);
     dgam.addArc(2,1,4);
     dgam.addArc(2,3,8);
     dgam.addArc(2,4,2);
     dgam.addArc(3,4,7);
     dgam.addArc(4,3,9);
     
     System.out.println(getPath(dijsktra(dgam,0),0,3)); 

     DigraphAlgorithms.dibujarGrafo(dgal);
     
     // Prints out the name of the vertex that has the most successors. Works for adjacency lists or matrices
     int mostSucc1 = DigraphAlgorithms.mostSuccessors(dgal);
     System.out.println(mostSucc1); 
     
     int mostSucc2 = DigraphAlgorithms.mostSuccessors(dgam);
     System.out.println(mostSucc2); 
     
     
     
     
 }
}