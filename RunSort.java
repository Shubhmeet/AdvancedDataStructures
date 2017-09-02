package cs6301.g24;

import java.util.Random;

public class RunSort {

	public static void main(String[] args){
		
		
		int size=10000;
		Integer[] arr = new Integer[size];
		Integer[] tmp=new Integer[arr.length];
		Random ran=new Random();
		for(int i=0;i<size;i++){
			arr[i]=ran.nextInt(size);
		}
	
		Timer time=new Timer();
		time.start();
		Sort.mergeSort(arr,tmp);
		time.end();
		System.out.println("generic Array  time merge sort "+ time.toString());
		
		time.start();
		int[] arr1=new int[size];
		int[] tmp1=new int[arr1.length];
	
		for(int i=0;i<size;i++){
			arr1[i]=ran.nextInt(size);
		}
		Sort.mergeSort(arr1, tmp1);
		time.end();
		System.out.println("int Array  time  merge sort"+ time.toString());
		
		time.start();
		Integer[] arr2=new Integer[size];
		
		for(int i=0;i<size;i++){
			arr2[i]=ran.nextInt(size);
		}
		Sort.nSquareSort(arr2);
		/*long totalExecutionTime=200;
		 while(System.currentTimeMillis() - time.startTime < totalExecutionTime )
		 {
			 Sort.nSquareSort(arr2);
			 System.out.println("time exceed");
		 }*/
		
		/*if(time.elapsedTime>200){
			System.out.println("too long");
		}*/
		time.end();
		System.out.println("generic Array  time nsquare sort"+ time.toString());
		
		//testing
		
		/*for(int i=0;i<size;i++){
			System.out.println(arr[i]);
		}
		
		for(int i=0;i<size;i++){
			System.out.println(arr1[i]);
		}
		for(int i=0;i<size;i++){
			System.out.println(arr2[i]);
		}*/
	}
}
