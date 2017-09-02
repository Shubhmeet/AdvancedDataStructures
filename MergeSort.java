
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
	
	public static void merge(int[] arr, int[] tmp, int start, int middle,int end){
		
		for(int i = start; i <= end; i++) {
	         tmp[i] = arr[i];
	    }
	   
	 int left = start;
	 int right = middle+1;
	   
	 int index=start;
	 while(index <= end)  {
	     if(left == middle+1) {
	    	 arr[index++] = tmp[right++];
	     } else if(right > end) {
	    	 arr[index++] = tmp[left++];
	     } else if(tmp[left]-tmp[right] <= 0){
	    	 arr[index++] = tmp[left++];
	     } else {
	    	 arr[index++] = tmp[right++];
	     }
	 }
		
}
