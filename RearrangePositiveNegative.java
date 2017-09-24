import java.util.Scanner;

public class RearrangePositiveNegative {

	private static int[] B;
	public static void main(String args[]){
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int n=scan.nextInt();
		System.out.println("Enter the elements: ");
		int[] A=new int[n];
		for(int i=0;i<n;i++){
			A[i]=scan.nextInt();
		}
		scan.close();
		rearrangeMinusPlus(A);
		for(int i=0;i<B.length;i++){
			System.out.println(B[i]);
		}
		
	}
	


    private static int[] rearrangeMinusPlus(int[] arr) { 
    	B=arr;
    	divide(0,arr.length-1);
	 return B;
   }
    //divide the array into sub parts
    public static void divide(int low, int high) {
		// base condition
    	if (low >= high)
			return;
		// Find the middle point
		int mid = (low + high) / 2;
		//divide the sub arrays further
		divide(low, mid);
		divide(mid + 1 , high);
		// merge the arrays after reversing
		merge(low, mid, high);

	}

    //merge the array into one array
	public static void merge(int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		while (i <= mid && B[i] <= 0)
			i++;
		while (j <= high && B[j] <= 0)
			j++;
		revElements(i, mid);
		revElements(mid + 1, j - 1);
		revElements(i, j - 1);
	}

	// reverse the elements
	public static void revElements(int left, int right) {
		while (right > left) {
			int temp = B[left];
			B[left] = B[right];
			B[right] = temp;
			left++;
			right--;
		}
	}
    
}