import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;



public class LongestPathInTree {

	public static void main(String[] args){
		
		
		Graph g=new Graph(10);
		g.addEdge(g.getVertex(1), g.getVertex(2), 0);
		g.addEdge(g.getVertex(2), g.getVertex(3), 0);
		g.addEdge(g.getVertex(3), g.getVertex(4), 0);
		g.addEdge(g.getVertex(3), g.getVertex(5), 0);
		g.addEdge(g.getVertex(1), g.getVertex(6), 0);
		g.addEdge(g.getVertex(6), g.getVertex(7), 0);
		g.addEdge(g.getVertex(6), g.getVertex(8), 0);
		g.addEdge(g.getVertex(7), g.getVertex(9), 0);
		g.addEdge(g.getVertex(8), g.getVertex(10), 0);
		
		Timer t=new Timer();
		t.start();
		LinkedList<Graph.Vertex> result=diameter(g);
		System.out.println(result);
		t.end();
		System.out.println(t.toString());
		
	}
	
	 public static LinkedList<Graph.Vertex> diameter(Graph g) { 
		 Graph.Vertex u=bfs(g.getVertex(1));
		 Graph.Vertex v=bfs(u);
		 boolean[] visited=new boolean[g.size()];
		 LinkedList<Graph.Vertex> result=new LinkedList<Graph.Vertex>();
		 LongestPathPrint(u,v,visited,result);
		return result;
	 }

	
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
	
	
	public static boolean LongestPathPrint(Graph.Vertex s, Graph.Vertex d ,
			boolean[] visited,LinkedList<Graph.Vertex> result){
		
		visited[s.getName()]=true;
		result.add(s);
		if(s.getName()==d.getName()){	
			return true;
		}else{
			for(Graph.Edge e:s){
				if(!visited[e.otherEnd(s).name])
					if(LongestPathPrint(e.otherEnd(s),d,visited,result)) return true;
					
			}
		}
		result.remove(result.size()-1);
		return false;
	}
	
}
