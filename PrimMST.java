

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;

/* Ver 1.0: Starter code for Prim's MST algorithm */

import java.util.Scanner;

import cs6326.g24.Graph.Edge;

public class PrimMST {
	static final int Infinity = Integer.MAX_VALUE;
	static Graph g;

	public PrimMST(Graph g) {
		PrimMST.g = g;
	}

	// SP6.Q4: Prim's algorithm using PriorityQueue<Edge>:
	public int prim1(Graph.Vertex s) {
		int wmst = 0;
		Graph.Vertex src = s;
		//ComparatorQ q = new ComparatorQ();
		PriorityQueue<Graph.Edge> pq = new PriorityQueue<>(PrimMST.g.size(), new Comparator<Graph.Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		for (Graph.Edge e : src.adj) {
			pq.add(e);
		}
		src.seen = true;

		while (!pq.isEmpty()) {

			Graph.Edge e = pq.poll();

			if (e.from.seen == true && e.to.seen == true)
				continue;
			wmst += e.weight;
			Graph.Vertex otherEnd;
			if (e.from.seen == true)
				otherEnd = e.to;
			else
				otherEnd = e.from;

			otherEnd.seen = true;
			for (Graph.Edge edge : otherEnd.adj) {
				if (!(edge.from.seen == true && edge.to.seen == true))
					pq.add(edge);
			}

		}

		return wmst;
	}

	public int prim2(Graph.Vertex s) {
		int wmst = 0;

		// SP6.Q6: Prim's algorithm using IndexedHeap<PrimVertex>:

		return wmst;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;

		if (args.length > 0) {
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		} else {
			in = new Scanner(System.in);
		}

		Graph g = Graph.readGraph(in);
		Graph.Vertex s = g.getVertex(1);

		Timer timer = new Timer();
		PrimMST mst = new PrimMST(g);
		int wmst = mst.prim1(s);
		timer.end();
		System.out.println(wmst);
	}
}
