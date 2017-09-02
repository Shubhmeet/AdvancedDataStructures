import java.util.Arrays;
import java.util.Random;

public class GeneralMergeSort {

	public static void main(String[] args){
		
		Timer time=new Timer();
		int size=6000000;
		Integer[] a = new Integer[size];
		Integer[] t=new Integer[a.length];
		
		Random ran=new Random();
		for(int i=0;i<size;i++){
			a[i]=ran.nextInt(size);
		}
		time.start();
		//Arrays.sort(a);
		mergeSort(a,t);
		time.end();
		System.out.println(time.toString());
		
	}
	public static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp){
		sort(arr,tmp,0, arr.length-1);
	}
	
	public static<T extends Comparable<? super T>> void sort(T[] arr, T[] tmp, int left, int right){
		if( left < right )
		{
			int center = (left + right) / 2;
			sort(arr, tmp, left, center);
			sort(arr, tmp, center + 1, right);
			merge(arr, tmp, left, center + 1, right);
		}
	}
	public static<T extends Comparable<? super T>> void merge(T[] arr, T[] tmp, int start, int middle,int end){
		int leftEnd = middle - 1;
		int index = start;
		int leftTmp = start;
		
		while ( start <= leftEnd && middle <= end  ) {
			if ( arr[start].compareTo( arr[middle] ) <= 0 )
				tmp[ index++ ] = arr[ start++ ];
			else 
				tmp[ index++ ] = arr[ middle++ ];
		}
		
		//copy the rest element of the left half subarray.
		while ( start <= leftEnd ) 
			tmp[ index++ ] = arr[ start++ ];
		//copy the rest elements of the right half subarray. (only one loop will be execute)
		while ( middle <= end ) 
			tmp[ index++ ] = arr[ middle++ ];
		
		//copy the tmp back cause we need to change the arr array items.
		for ( ; end >= leftTmp; end-- )
			arr[end] = tmp[end];
	}
}
