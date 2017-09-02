package cs6301.g24;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

public static Graph.Vertex bfs(Graph.Vertex u){
		
		Queue<Graph.Vertex> queue =new LinkedList<Graph.Vertex>();
		Set<Graph.Vertex> set= new HashSet<Graph.Vertex>();
		queue.offer(u);
		Graph.Vertex v = null;
		while(!queue.isEmpty()){
			 v=queue.poll();
			for(int i=0;i<v.adj.size();i++){
				Graph.Vertex t=v.adj.get(i).otherEnd(v);	
				if(!set.contains(t)){
					queue.add(t);
					set.add(t);
				}
				
			}
		}
		
		return v;
		
	}


}
