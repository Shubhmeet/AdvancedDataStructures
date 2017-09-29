/** @author 
 *Shubhmeet Kaur : skx162731
 *Amrita Nath : axn163530
 *Mayank Goyall: mxg163230
 *Teja Krishna Talluri: tkt160230
 *  Ver 1.0: 09/23/2017
 */
public class MergeSort4Version {

	//general basic merge sort
	public static void mergeSort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void mergeSort(int[] arr , int start, int end){
		if(end>start){
			//find the middle
			int mid=(start+end)/2;
			//call mergeSort for left half
			mergeSort(arr,start,mid);
			//call merge sort for right half
			mergeSort(arr, mid+1,end);
			//merge the two halfs
			merge(arr, start,mid,end);
		}
	}
	//merge the divided arrays into 1
	public static void merge(int[] arr , int start,int mid, int end){
		int n=mid-start+1;
		int m=end-mid;
		
		int L[] = new int [n];
        int R[] = new int [m];
 
       
        for (int i=0; i<n; ++i)
            L[i] = arr[start + i];
        for (int j=0; j<m; ++j)
            R[j] = arr[mid + 1+ j];
        
        
        int i = 0, j = 0;
        
        // Initial index of merged subarry array
        int k = start;
        while (i < n && j < m)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i++];
             
            }
            else
            {
                arr[k] = R[j++];
               
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n)
        {
            arr[k++] = L[i++];
            
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < m)
        {
            arr[k++] = R[j++];
            
        }
 
	}
	
	
	//merge sort using temp array
	public static void mergeSort(int[] arr, int[] tmp){
		mergesort(arr,tmp,0, arr.length-1);
	}
	
	
	private static void mergesort(int[] arr, int[] tmp, int start, int end){
		if( start< end )
		{
			// divide the array in two parts and call sort recursively
			int middle = (start+end)/ 2;
			//call sort for left half
			mergesort(arr, tmp, start, middle);
			//call sort for right half
			mergesort(arr, tmp, middle + 1, end);
			//merge the two divided array
			merge(arr, tmp, start, middle , end);
		}
	}
	
	private static void merge( int[] arr, int[] tmp,int start, int middle, int end ) {
		//copy the elements to temp array
		for(int i=start;i<=end;i++){
			tmp[i]=arr[i];
		}
		int i=start , j=middle+1;
		for(int k=start;k<=end;k++){
			//copy the elements into arr after checking them in tmp
			if(j>end ||  (i<=middle && tmp[i]<=tmp[j]))
				arr[k]=tmp[i++];
			else
				arr[k]=tmp[j++];
		}
	}
	
	
	
	public static void mergeSortImprovement1(int[] arr, int[] tmp){
		mergeSortImprovement1(arr,tmp,0, arr.length-1);
	}
	private static void mergeSortImprovement1(int[] arr, int[] tmp, int start, int end){
		if(end-start<17){
			insertionSort(arr,start,end);
		}
		else
		{
			// divide the array in two parts and call sort recursively
			int middle = (start+end)/ 2;
			mergeSortImprovement1(arr, tmp, start, middle);
			mergeSortImprovement1(arr, tmp, middle + 1, end);
			//merge the two divided array
			merge(arr, tmp, start, middle , end);
		}
	}
	
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
//            int key = arr[i];
//            int j = i-1;
// 
//            /* Move elements of arr[0..i-1], that are
//               greater than key, to one position ahead
//               of their current position */
//            while (j>=0 && arr[j] > key)
//            {
//                arr[j+1] = arr[j];
//                j = j-1;
//            }
//            arr[j+1] = key;
        }
  }
	
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//avoiding the use of copying elements to temp array
	public static void mergeSortImprovementFinal(int[] A){
		int[] B = new int[A.length];
		System.arraycopy(A, 0, B, 0, A.length);
	    mergeSortImprovementFinal(A, B, 0, A.length-1);
	}
	

	
    private static void mergeSortImprovementFinal(int[] A, int [] B, int start, int end){
	 
    	if(end-start<7)
    		insertionSort(A,start,end);
    	else{
    		//find middle
    		int mid = start + (end - start) / 2;
    		//divide the left array
    		mergeSortImprovementFinal(B, A, start,mid);
    		//divide the right array
    		mergeSortImprovementFinal(B, A, mid + 1, end);
    		//call merge operation
    		mergeImprovementFinal(B, A, start, mid, end);

    	}
   }
    
    private static void mergeImprovementFinal( int[] A, int[] B,int start, int middle, int end ) {
//		int i=start , j=middle+1;
//		// stores the sorted array in A
//		for(int k=start;k<=end;k++){
//			if(j>end ||  (i<=middle && A[i]<=A[j]))
//				B[k]=A[i++];
//			else
//				B[k]=A[j++];
//		}
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

	
	
	
}
