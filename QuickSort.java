import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		//create object of scanner class
				Scanner scan=new Scanner(System.in);
				int size=scan.nextInt();
				//close scanner object
				scan.close();
				
				//create object of random generator class
				Random rand=new Random();
				
				int[] A=new int[size];
				
				for(int i=0;i<size;i++){
					A[i]=rand.nextInt(size);
				}
				Shuffle.shuffle(A);
				int[] B = new int[A.length];
				
				System.arraycopy(A, 0, B, 0, A.length);
				
				//testing 
				/*for(int x:A)
					System.out.print(x+" ");
				System.out.println();
				for(int y:B)
					System.out.print(y+" ");
				System.out.println();
				*/
				
				//create object of timer class
				Timer time=new Timer();
				time.start();
				//call quick sort
				quickSort(A);
				time.end();
				System.out.println(time.toString());
				
				
				time.start();
				//call quickSort
				dualQuickSort(B);
				time.end();
				System.out.println(time.toString());
				
				
				
				//testing 
					/*for(int x:A)
							System.out.print(x+" ");
						System.out.println();
						for(int y:B)
							System.out.print(y+" ");
						System.out.println();
						*/
				
			}
	
	
	
	public static void quickSort(int[] A){
		quickSort(A,0,A.length-1);
	}
	
	public static void quickSort(int[] A , int start, int end){
		if(start<end)
		{ int q = partition(A,start,end);
		   quickSort(A,start,q-1);
		   quickSort(A, q+1, end);
		}
	}
	
	public static int partition(int[] A, int p , int r){
		int x=A[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			if(A[j]<x){
				i++;
				swap(A,i,j);
			}
		}
		swap(A, i+1,r);
		return i+1;
	}

    //Dual Quick Sort
	public static void dualQuickSort(int[] A){
		
		dualQuicksort(A,0,A.length-1);
	}
	
	
	private static void dualQuicksort(int[] A, int start, int end) {
	      if (end<=start) return;
	      if(end-start<5)
	    	  insertionSort(A,start,end);
	      
	      int pivot1=A[start];
	      int pivot2=A[end];
	      
	      
	      if (pivot1>pivot2){
	          swap(A, start, end);
	          pivot1=A[start];
	          pivot2=A[end];
	          //sort(A, start, end);
	      }
	     
	
	      int low=start+1;
	      int left=start+1;
	      int high=end-1;
	      
	      while (low<=high){
	          
	          if (A[low]<pivot1){
	              swap(A, low++, left++);
	          }
	          else if (pivot2<A[low]){
	              swap(A, low, high--);
	          }
	          else{
	              low++;
	          }
	          
	      }
	      
	      left--;
	      swap(A, start, left);
	      high++;
	      swap(A, end, high);
	      //call quicksort for 1st subarray
	      dualQuicksort(A, start, left-1);
	      
	      //call quicksort for 2nd subarray
	      dualQuicksort (A, left+1, high-1);
	      
	      //call quicksort for 3rd subarray
	      dualQuicksort(A, high+1, end);
	          
	  }
	
	//insertion sort 
		private static void insertionSort(int[] arr, int start,int end){
			
	      for (int i=start; i<=end; ++i)
	      {
	      	for(int j = i + 1; j <= end; j++)
	      	{
	      		if( arr[j] < arr[i] )
	      		{
	      			swap(arr, i, j);
	      		}
	      	}
	      	
	      }
		}
		
		//swap the elements at A[i] and A[j]
		public static void swap(int[] arr, int i, int j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
}