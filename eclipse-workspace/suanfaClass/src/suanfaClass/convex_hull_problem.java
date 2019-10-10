package suanfaClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Convex-hull problem
 * @author whoeiy
 * @method BruteForce
 * @input a point list
 * @output a point list consisted of convex-hull
 * @completion_time 20191010
 */

public class convex_hull_problem {
	public static void main(String args[])
	{
		int[][] p = {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
		List<String> res = BruteForceConvexHull(p);
		for(String s: res)
		{
			System.out.println(s);
		}
	}
	
	public static List<String> BruteForceConvexHull(int[][] p)
	{
		int flag1, flag2;
		int a, b, c;
		int i, j, k;
		List<String> res = new ArrayList<>();
		String resi, resj;
		
		for(i = 0; i < p.length; i++)
		{
			for(j = i + 1; j < p.length; j++)
			{
				flag1 = 0;
				flag2 = 0;
				a = p[j][1] - p[i][1];
				b = p[i][0] - p[j][0];
				c = p[i][0] * p[j][1] - p[i][1] * p[j][0];
				for(k = 0; k < p.length; k++)
				{
					if(k == i || k == j)
						continue;
					if(a * p[k][0] + b * p[k][1] - c >= 0)
					{
						flag1++;
					}
					if(a * p[k][0] + b * p[k][1] - c <= 0)
					{
						flag2--;
					}
				}
				if(flag1 == p.length - 2 || flag2 == 2 - p.length)
				{
					resi = "("+p[i][0]+","+p[i][1]+")";
					resj = "("+p[j][0]+","+p[j][1]+")";
					if(!res.contains(resi))
					{
						res.add(resi);
					}
					if(!res.contains(resj))
					{
						res.add(resj);
					}
				}	
			}
		}
		return res;
	}
}
