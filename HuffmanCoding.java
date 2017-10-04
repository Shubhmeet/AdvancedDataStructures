
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {

	public static ArrayList<Character> path;
	public static ArrayList<String> value;

	public static HuffNode HuffMan(char[] c, double[] f) {

		PriorityQueue<HuffNode> pq = new PriorityQueue<>(c.length, new Comparator<HuffNode>() {
			@Override
			public int compare(HuffNode o1, HuffNode o2) {
				if (o1.frequency > o2.frequency)
					return 1;
				else if (o1.frequency < o2.frequency)
					return -1;
				return 0;
			}
		});

		for (int i = 0; i < c.length; i++) {
			pq.add(new HuffNode(c[i], f[i]));
		}
		while (pq.size() > 1) {
			HuffNode x = pq.remove();
			HuffNode y = pq.remove();
			x.value = "0";
			y.value = "1";
			HuffNode z = new HuffNode(x.frequency + y.frequency, x, y);
			z.ltree = x;
			z.rtree = y;

			pq.add(z);

		}
		return pq.poll();

	}

	public static void main(String[] args) {

		char[] name = { 'a', 'b', 'c', 'd', 'e' };
		double[] freq = { 0.2, 0.1, 0.15, 0.3, 0.25 };
		HuffNode huffNode = HuffMan(name, freq);

		traverse(huffNode, "");

	}

	public static void traverse(HuffNode huffNode, String prefix) {

		if (huffNode.ltree == null && huffNode.rtree == null) {
			System.out.println(huffNode.name + " " + prefix);
			return;
		}

		traverse(huffNode.ltree, prefix + huffNode.ltree.value);

		traverse(huffNode.rtree, prefix + huffNode.rtree.value);

	}
}

class HuffNode {
	char name;
	double frequency;

	HuffNode ltree;
	HuffNode rtree;

	String value;

	public HuffNode(double freq, HuffNode ltree, HuffNode rtree) {
		this.frequency = freq;

		this.ltree = ltree;
		this.rtree = rtree;

	}

	public HuffNode(char name, double freq) {
		this.name = name;
		this.frequency = freq;

	}
}
