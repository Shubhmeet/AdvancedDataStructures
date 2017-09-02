package cs6301.g24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Diameter {

	public static  void main(String[] args) throws FileNotFoundException{
		Scanner in;
        if (args.length > 0) {
            File inputFile = new File(args[0]);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }
        Graph g = Graph.readGraph(in);
        Timer time=new Timer();
        time.start();
		LinkedList<Graph.Vertex> result=diameter(g);
		time.end();
		System.out.println(result);
		System.out.println(time.toString());
		
	}
	
	 public static LinkedList<Graph.Vertex> diameter(Graph g) {
		  Graph.Vertex source= BFS.bfs(g.getVertex(1));
		  Graph.Vertex destination =BFS.bfs(source);
		  LinkedList<Graph.Vertex> result=new LinkedList<>();
		  boolean[] visited=new boolean[g.size()];
		  LongestPathPrint(source, destination, visited, result);
		return result;
		 
	 }
	 private static boolean LongestPathPrint(Graph.Vertex s, Graph.Vertex d ,
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
