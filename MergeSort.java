
import java.util.Random;

public class MergeSort {

	public static void main(String[] args){
		Timer ti=new Timer();
		int size=6000000;
		int[] a = new int[size];
		int[] t=new int[a.length];
		
		Random ran=new Random();
		for(int i=0;i<size;i++){
			a[i]=ran.nextInt(size);
		}
		
		ti.start();
		mergeSort(a,t);
		ti.end();
		System.out.println(ti.toString());
		
	}
	
	public static void mergeSort(int[] arr, int[] tmp){
		sort(arr,tmp,0, arr.length-1);
	}
	
	public static void sort(int[] arr, int[] tmp, int left, int right){
		if( left < right )
		{
			int center = (left + right) / 2;
			sort(arr, tmp, left, center);
			sort(arr, tmp, center + 1, right);
			merge(arr, tmp, left, center + 1, right);
		}
	}
	
	public static void merge(int[] arr, int[] tmp, int left, int right,int rightEnd){
		int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(arr[left]<=(arr[right]))
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
