import java.util.Scanner;

public class Largestelementlessthenx {

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int length=scan.nextInt();
		System.out.println("Enter array elements: ");
		Integer[] a=new Integer[length];
		for(int i=0;i<length;i++){
			a[i]=scan.nextInt();
		}
		
		System.out.println("Enter element to be searched ");
		Integer x=scan.nextInt();
		scan.close();
	    System.out.println("Index of largest element who is less then or equal to key x: "+binarySearch(a,x));
	
	}
	
	public static<T extends Comparable<? super T>> int binarySearch(T[] arr, T x){
		 return  binarySearch(arr, 0, arr.length-1, x);
		}
		

		private static<T extends Comparable<? super T>> int binarySearch(T[] arr, int low, int high, T x) {
		// base condition to exit
			if (low > high)
		        return -1;
		 
		    // If last element is smaller than x
		    if (x.compareTo(arr[high])>0)
		        return high;
		 
		    // Find the middle point
		    int mid = (low+high)/2;
		 
		    // If middle point is key.
		    if (arr[mid] == x)
		        return mid;
		 
		    // If x lies between mid-1 and mid
		    if (mid > 0 && arr[mid-1].compareTo(x)<=0 && x.compareTo(arr[mid])<0)
		        return mid-1;
		 
		    // If x is smaller than mid, floor must be in
		    // left half.
		    if (x.compareTo(arr[mid])<0)
		        return binarySearch(arr, low, mid-1, x);
		 
		   
		    return binarySearch(arr, mid+1, high, x);
			
	}

		
}


	

