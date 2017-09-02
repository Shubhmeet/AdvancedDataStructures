package cs6301.g24;

public class Sort {

	public static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp){
		sort(arr,tmp,0, arr.length-1);
	}
	
	private static<T extends Comparable<? super T>> void sort(T[] arr, T[] tmp, int start, int end){
		if( start < end )
		{
			int middle = (start + end) / 2;
			sort(arr, tmp, start, middle);
			sort(arr, tmp, middle + 1, end);
			merge(arr, tmp, start,middle+1, end);
		}
	}
	private static <T extends Comparable<? super T>> void merge( T[] arr, T[] tmp,
			int start, int middle, int end ) {
		int startEnd = middle - 1;
		int index = start;
		int startTmp = start;
		
		while ( start <= startEnd && middle <= end  ) {
			if ( arr[start].compareTo( arr[middle] ) <= 0 )
				tmp[ index++ ] = arr[ start++ ];
			else 
				tmp[ index++ ] = arr[ middle++ ];
		}
		while ( start <= startEnd ) 
			tmp[ index++ ] = arr[ start++ ];
		while ( middle <= end ) 
			tmp[ index++ ] = arr[ middle++ ];
		while(end>=startTmp)
			arr[end] = tmp[end--];		
	}
	
	public static void mergeSort(int[] arr, int[] tmp){
		sort(arr,tmp,0, arr.length-1);
	}
	private static void sort(int[] arr, int[] tmp, int start, int end){
		if( start< end )
		{
			int middle = start+ (end-start)/ 2;
			sort(arr, tmp, start, middle);
			sort(arr, tmp, middle + 1, end);
			merge(arr, tmp, start, middle+1 , end);
		}
	}
	private static void merge( int[] arr, int[] tmp,int start, int middle, int end ) {
		int startEnd = middle - 1;
		int index = start;
		int startTmp = start;
		
		while ( start <= startEnd && middle <= end  ) {
			if ( arr[start] - arr[middle] <= 0 )
				tmp[ index++ ] = arr[ start++ ];
			else 
				tmp[ index++ ] = arr[ middle++ ];
		}
		while ( start <= startEnd ) 
			tmp[ index++ ] = arr[ start++ ];
		while ( middle <= end ) 
			tmp[ index++ ] = arr[ middle++ ];
		while(end>=startTmp)
			arr[end] = tmp[end--];	
	}
	
	public static<T extends Comparable<? super T>> void nSquareSort(T[] arr){
		T temp;
		for(int i = 1; i < arr.length; i++) {

            for(int j = i; (j > 0 ) && (arr[j].compareTo(arr[j-1]) < 0); j--) {
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

            }

        }

	}
	
	
}
