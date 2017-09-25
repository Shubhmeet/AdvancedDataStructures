

import java.math.BigInteger;


public class Fibonacci {

	/*
	 *  identity matrix = 1 1
	 *  				  1 0
	 */
	static BigInteger[][] matrix = { { BigInteger.ONE, BigInteger.ONE },
										{ BigInteger.ONE, BigInteger.ZERO } 
									};
	static BigInteger zero = BigInteger.ZERO; // zero = 0
	static BigInteger one = BigInteger.ONE;  // one =1
	static BigInteger two = one.add(one);   // two = 2
	
	
	// return BigInteger at nth index of fibonacci series using linear fibonacci method
	static BigInteger linearFibonacci(int n) 
	{ 
		// return 0 if n is 0
		if(n==0)
		return zero;
		
		// return 1 if nis either 1 or 2
		else if(n==1||n==2)
			return one;
		
		else{
		BigInteger[] fib = new BigInteger[n+1] ;
		fib[0] = zero;
		fib[1] = one;
		fib[2] = one;
		
		//calculating fibonacci number till n iteratively
		for(int i=3;i<=n;i++)
		{
			fib[i] = fib[i-1].add(fib[i-2]);
		}
		return fib[n];
		}
		
		
	}
	static BigInteger logFibonacci(int n) { 
		/*
		 *   matrix temp    = 1 1
		 *  				  1 0
		 */
		BigInteger[][] temp = matrix;
		
		/*
		 * matrix temp2 = 1
		 * 		  		  0
		 * */
		BigInteger[][] temp2 = {
								{BigInteger.ONE},
								{BigInteger.ZERO}
								};
		
		
		if (n == 0)
			return BigInteger.ZERO;
		else if (n == 1 || n == 2)
			return BigInteger.ONE;
		else
		{
			
			BigInteger[][] intermediateTResult = matrixPower(temp, n - 1);
			
			BigInteger[][] result = matrixMulti(intermediateTResult,temp2);

			return result[0][0];
		}
		
		
	}

	private static BigInteger[][] matrixPower(BigInteger[][] temp, int l)
	{
		if(l==0)
			return matrix;
		
		else if(l==1)
			return temp;

		else
		{
			BigInteger[][] half = matrixPower(temp, l / 2);

			BigInteger[][] half2 = matrixMulti(half,half);
			
			if(l%2==0)
			{
				
				
				return half2;
			}
			else{
				
				
				return matrixMulti(half2,matrix);
			}
			
		}
	}
	
	private static BigInteger[][] matrixMulti(BigInteger[][] temp1, BigInteger[][] temp2)
	{

	   int row1 = temp1.length;
	   int col1 = temp1[0].length;
	   int row2 = temp2.length;
	   int col2 = temp2[0].length;
		BigInteger sum = BigInteger.ZERO;
		
		BigInteger[][] result = new BigInteger[row1][col2] ;
		for(int i=0;i<row1;i++)
		{
			for(int j=0;j<col2;j++)
			{
				for(int k=0;k<row2;k++)
				{
					
					BigInteger temp3 = temp1[i][k].multiply(temp2[k][j]);
					
					sum = sum.add(temp3);
					
				}
				
				result[i][j]=sum;
				sum = BigInteger.ZERO;
			}
		}

		return result;
		
	}
	
	
	public static void main(String[] args)
	{
		Timer time=new Timer();
        time.start();
        System.out.println(linearFibonacci(123456));   // 11th fibonacci number
		System.out.println(time.end());
		
		
		Timer time2=new Timer();
        time2.start();
		System.out.println(logFibonacci(123456));	// 11th fibonacci number
		System.out.println(time2.end());
		
	
	}
	
}
