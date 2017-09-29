/** @author 
 *Shubhmeet Kaur : skx162731
 *Amrita Nath : axn163530
 *Mayank Goyall: mxg163230
 *Teja Krishna Talluri: tkt160230
 *  Ver 1.0: 09/23/2017
 */
import java.util.Random;
import java.util.Scanner;



public class CallableSort {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Timer time=new Timer();
		
		int size=in.nextInt();
		int[] arr1=new int[size];
		
		//make a object of random class
		Random ran=new Random();
		for(int i=0;i<size;i++){
			// to create random elements
			arr1[i]=ran.nextInt(size);	
		}
		//shuffle method shuffles the array elements
		Shuffle.shuffle(arr1);
		int[] arr2=arr1.clone();;
		int[] arr3=arr1.clone();
		int[] arr4=arr1.clone();
		/*for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+" ");
		System.out.println("-------");
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr2[i]+" ");
		System.out.println("-------");
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr3[i]+" ");
		System.out.println("-------");
		*/
//		for(int i=0;i<arr4.length;i++)
//			System.out.print(arr4[i]+" ");
		
		
//		time.start();
//		Sort.mergeSort(arr1);
//		time.end();
//		System.out.println("Running time for Basic Merge Sort"+ time.toString());
//		
//		
//		
//		int[] tmp=new int[arr1.length];
//		time.start();
//		Sort.mergeSort(arr2, tmp);
//		time.end();
//		System.out.println("Running time for Merge Sort using temp array"+time.toString());
//		
//		
//		int[] temp=new int[arr3.length];
//		time.start();
//		Sort.mergeSortImprovement1(arr3, temp);
//		time.end();
//		System.out.println("Running time for Merge sort after using Insertion sort "+time.toString());
		
		
		time.start();
		MergeSort4Version.mergeSortImprovementFinal(arr4);
		time.end();
		System.out.println("Running time for Merge Sort, removing the use of copying elements to temp array "+time.toString());
		
		//testing
		/*for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+" ");
		System.out.println("-------");
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr2[i]+" ");
		System.out.println("-------");
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr3[i]+" ");
		System.out.println("-------");
		*/
//		for(int i=0;i<arr4.length;i++)
//			System.out.print(arr4[i]+" ");
		
	}
	
	
	
	
	
	
	
	
	
}
