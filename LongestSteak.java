package cs6326.g24;

import java.util.Arrays;

public class LongestSteak {

	public static void main(String[] args) {
		int[] num={1,7,9,4,1,7,4,8,7,1,9,10};
		System.out.println(longestStreak(num));
	}
	// methods find the length of longest consecutive integers 
	public static int longestStreak(int[] num){
		//sort the elements
		Arrays.sort(num);
		int count=1,max_count = 0;
		
		//traverse the elements
		  for(int i=0;i<num.length-1;++i){
		        if(num[i+1] == (num[i]+1))
		            count++;
		        else if(num[i+1] == num[i])
		            continue;
		        else{
		            if(max_count<count)
		                max_count = count;
		            count = 1;
		        }
		    }
		  
		    if(max_count<count)
		        max_count = count;
		    return max_count;
		
	}
	
	
}
