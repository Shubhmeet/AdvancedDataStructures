
public class Sort {

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
	//avoiding the use of copying elements to temp array
	public static void mergeSort(int[] A){
		int[] B = new int[A.length];
		//create a copy of Array A
		System.arraycopy(A, 0, B, 0, A.length);
	    mergeSort(A, B, 0, A.length-1);
	}
	
	private static void mergeSort(int[] A, int [] B, int start, int end){
		 
    	if(end-start<5)
    		insertionSort(A,start,end);
    	else{
    		//find middle
    		int mid = start + (end - start) / 2;
    		//divide the left array
    		mergeSort(B, A, start,mid);
    		//divide the right array
    		mergeSort(B, A, mid + 1, end);
    		//call merge operation
    		merge(B, A, start, mid, end);

    	}
   }
    
    private static void merge( int[] A, int[] B,int start, int middle, int end ) {

    	int i = start, j = middle + 1, k = start;
    	while( i <= middle && j <= end )
    	{
    		if(A[i] <= A[j])
    			B[k] = A[i++];
    		else
    			B[k] = A[j++];
    		k++;
    	}
    	
    	while( i <= middle )
    		B[k++] = A[i++];
    	
    	while( j <= end )
    		B[k++] = A[j++];
	}

	
    
    //Quick Sort
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

}
