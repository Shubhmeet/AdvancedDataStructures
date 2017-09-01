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
	public static<T extends Comparable<? super T>> void merge(T[] arr, T[] tmp, int left, int right,int rightEnd){
		int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(arr[left].compareTo(arr[right])<=0)
                tmp[k++] = arr[left++];
            else
                tmp[k++] = arr[right++];

        while(left <= leftEnd)    
            tmp[k++] = arr[left++];

        while(right <= rightEnd) 
            tmp[k++] = arr[right++];
        for(int i = 0; i < num; i++, rightEnd--)
            arr[rightEnd] = tmp[rightEnd];
	}
}
