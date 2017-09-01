import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args){
		Integer[] a = {2, 6, 3, 5, 1};
		Timer time=new Timer();
		time.start();
		nSquareSort(a);
		System.out.println(Arrays.toString(a));
		time.end();
		System.out.println(time.toString());
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
