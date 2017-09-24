import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kMissingNumbers {
 // to store the missing numbers from sorted array
	public static List<Integer> result=new ArrayList<>();
	
	public static void main(String args[]){
		//create a scanner object to read input from user 
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the size of array: ");
	     
		// read the size of array
	    int length=scan.nextInt();
	    System.out.println("Enter elements in sorted array: ");
	    int[] a=new int[length];
	    
	    for(int i=0;i<length;i++){
	     // read the elements
	    	a[i]=scan.nextInt();
	     }
	    
	    //close the scanner object
	    scan.close();
	    
	    //call method to find missing k numbers
		findMissingNumbers(a);
		
		System.out.println("Missing elements are: ");
		
		// display the missing elements
		if(result.size()==0)
			System.out.println("No element is missing");
		else
			System.out.println(result);
		
	}
	public static void findMissingNumbers(int[] a){
		findMissingNumbers(a, 0, a.length-1);
	}
	
	public static void findMissingNumbers(int[] a , int start , int end){
		//if no element is missing
		if((a[start]-a[end])==(start-end))
			return;
		
		if(end<start)
			return;
		
		// find the middle element
		int mid=(start+end)/2;
		
		//find all the missing numbers in left sub array
		findMissingNumbers(a,start,mid);
		
		//add the elements missing between the middle and middle+1 index elements
		if(a[mid]!=(a[mid+1]-1)){
			for(int i=a[mid]+1;i<a[mid+1];i++){
				result.add(i);
			}
		}
		// find missing numbers in right sub array
		findMissingNumbers(a, mid+1, end);
		
	}
}
