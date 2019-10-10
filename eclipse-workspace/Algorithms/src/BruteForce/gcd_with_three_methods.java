package BruteForce;

import java.util.*;

/**
 * gcd
 * @author whoeiy
 * @method_1 Euclidean algorithm
 * @method_2 Recursion
 * @method_3 BruteForce
 * @completion_time 20190919
 */

//import java.lang.Math;

public class gcd_with_three_methods {
	public static void main(String args[])
	{
		int result1, result2;
		int m = 63;
		int n = 84;
//		int m = 33;
//		int n = 22;
		result1 = euclid(m,n);
		result2 = func2(m,n);
		System.out.print("result1:"+result1+"\nresult2:"+result2+"\nresult3:");
		func3(m,n);
	}
	
	public static int euclid(int m, int n)
	{
		int r;
		while(n != 0)
		{
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	public static int func2(int m, int n)
	{
		int t = Math.min(m,n);
		
		while(true)
		{
			if(m % t == 0)
			{
				if(n % t == 0)
				{
					break;
				}
				else
				{
					t--;
				}
			}
			else
			{
				t--;
			}
		}
		return t;
	}
	
	
	public static void func3(int m, int n)
	{
		int value;
		boolean flag = false;
		//找到m的质因数
		int[] zhi_m = Sieve(m);
//		List<String> zhiyin_m = new ArrayList<String>();
		Map<Integer, Integer> zhiyin_m = new HashMap<Integer,Integer>();
		int i;
//		int k = 0;
		for(i = 0; i < zhi_m.length; i++)
		{	
			if(m % zhi_m[i] == 0)
			{
				if(zhiyin_m.get(zhi_m[i]) != null)
				{
					value = zhiyin_m.get(zhi_m[i]) + 1;
					zhiyin_m.put(zhi_m[i], value);
					flag = true;
				}
				else
				{
					zhiyin_m.put(zhi_m[i],1);
				}
			}	
		}
		
		
		//找到n的质因数
		int[] zhi_n = Sieve(n);
		Map<Integer, Integer> zhiyin_n = new HashMap<Integer,Integer>();
//		List<String> zhiyin_n = new ArrayList<String>();
		for(i = 0; i < zhi_n.length; i++)
		{
			if(n % zhi_n[i] == 0)
			{
				if(zhiyin_n.get(zhi_n[i]) != null)
				{
					value = zhiyin_n.get(zhi_n[i]) + 1;
					zhiyin_n.put(zhi_n[i], value);
				}
				else
				{
					zhiyin_n.put(zhi_n[i],1);
				}
			}	
		}
		
		//找到公因数和其分别出现的次数
//		List<String> zhiyin_com = new ArrayList<String>();
		Map<Integer, Integer> zhiyin_com = new HashMap<Integer, Integer>();
        for(int k : zhiyin_m.keySet())
        {
        	for(int l : zhiyin_n.keySet())
        	{
        		if(k == l)
        		{
//        			System.out.println("test:k "+k);
        			zhiyin_com.put(k,Math.min(zhiyin_m.get(k),zhiyin_n.get(l)));
        		}
        	}
        }

        int key;
        int res = 1;
        Set<Integer> keySet_com = zhiyin_com.keySet();
        Iterator<Integer> it_com = keySet_com.iterator();
        int value_com;
		while(it_com.hasNext())
		{
			key = it_com.next();
			value_com = zhiyin_com.get(key);
			res = res * pow(key, value_com);
//			System.out.println(res);
		}
		System.out.println(res);
	}
	
	public static int pow(int a,int N)
	{
		if(N==0)
			return 1;
		else
			return a  * pow(a,N-1);
	}
	
	public static int[] Sieve(int n)
	{
		int i, j;
		int k = 0;
		int cal = 0;
		int[] A = new int[n+1]; 
		for(i = 2; i <= n; i++)
		{
			A[i] = i;
		}
		for(i = 2; i <= Math.floor(Math.sqrt(n)); i++)
		{
			if(A[i] != 0)
			{
				j = i * i;
				while(j <= n)
				{
					A[j] = 0;
					j = j + i;
				}
			}
		}
		for(i = 2; i <= n; i++)
		{
			if(A[i] != 0)
			{
				cal++;
			}
		}
		int[] L = new int[cal];
		for(i = 2; i <= n; i++)
		{
			if(A[i] != 0)
			{
				L[k] = A[i];
				k = k + 1;
			}
		}
		return L;
	}
}
