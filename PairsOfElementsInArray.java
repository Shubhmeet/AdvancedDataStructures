package cs6326.g24;

import java.util.Arrays;

public class PairsOfElementsInArray {

	static void findThePairs(int input[], int inputNumber)
    {
        //Sorting the given array
		int counter =0 ;
 
        Arrays.sort(input);
 
        System.out.println("Pairs of elements whose sum is "+inputNumber+" are : ");
 
        //Initializing i to first index
 
        int i = 0;
 
        //Initializing j to last index
 
        int j = input.length-1;
 
        //Till i crosses j, perform the following task
        int left=1; int right=1;
        while (i < j)
        {
            //If input[i]+input[j] is equal to inputNumber
 
            if(input[i]+input[j] == inputNumber)
            {
                if(input[i]==input[i+1] && i+1!=j && input[j]==input[j-1] && j-1!=i){
                	left+=1;
                	right+=1;
                	i++;
                	j--;
                }
              
                else if(input[i]!=input[i+1] && i+1!=j){
                	
                	counter += left*right;
                	left=1;
                	j--;
                }
                else if(input[j]!=input[j-1] && j-1!=i)
                {  
                	counter+= left*right;
                	right=1;
                	i++;
                }
                else{
                	counter+= left*right;
                	i++;
                	j--;
                }
               
            }
 
            //If input[i]+input[j] is smaller than inputNumber
 
            else if (input[i]+input[j] < inputNumber)
            {
                //then increment i
 
                i++;
            }
 
            //If input[i]+input[j] is greater than inputNumber
 
            else if (input[i]+input[j] > inputNumber)
            {
                //then decrement j
 
                j--;
            }
        }
     System.out.println(counter);   
    }
 
    public static void main(String[] args)
    {
        findThePairs(new int[] {3,3,3,4,5,5,5}, 8);
 
        findThePairs(new int[] {4, -5, 9, 11, 25, 13, 12, 8}, 20);
 
        findThePairs(new int[] {12, 13, 10, 15, 8, 40, -15}, 25);
 
    }
}
