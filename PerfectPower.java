package cs6326.g24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PerfectPower {

	public static ArrayList<Long> result=new ArrayList<>();
	
	public static void main(String args[]) {
		//create object of scanner
		Scanner scan=new Scanner(System.in);
		// enter the n 
		int n =scan.nextInt();
		//close scanner object
		scan.close();
		
		//find perfect powers 
		Perfectpower(n);
		
		//print numbers
		printPerfectNumbers();
	}
 
	
	//find perfect powers upto n
	public static void Perfectpower(int n) {
		long valuecheck = 0;
		
		PriorityQueue<PerfectNumber> pq = new PriorityQueue<>(new Comparator<PerfectNumber>() {
			@Override
			public int compare(PerfectNumber o1, PerfectNumber o2) {
				return (int) (o1.value - o2.value);
			}
		});

		//base condition
		pq.add(new PerfectNumber(2, 2));
		
		while (!pq.isEmpty()) {
			
			PerfectNumber z = pq.remove();
			
			//return when a^b >n 
			if(Math.pow(z.a, z.b)>n){
				return;
			}
			
			//to avoid duplicacy
			if(valuecheck!=z.value){
				result.add(z.value);
				valuecheck = z.value;
			}
			
			
			// add next elements in priorrity queue
			if (z.a == 2) {
				pq.add(new PerfectNumber(2, z.b + 1));
				pq.add(new PerfectNumber(3, z.b));

			} else {
				pq.add(new PerfectNumber(z.a + 1, z.b));
			} 
		}

	}
	
	//print the perfect numbers
	public static void printPerfectNumbers(){
		for(Long x:result){
			System.out.println(x);
		}
	}
}

//class depicting the triplet a, b ,a^b
class PerfectNumber {
	int a;
	int b;
	long value;

	PerfectNumber(int a, int b) {
		this.a = a;
		this.b = b;
		value = (long) Math.pow(a, b);
	}
}
