public class closest_pari_of_points {
	public void main(String args[])
	{
		int p[][] = {{25,20},{7,13},{38,40},{42,13},{26,2},{44,33},{0,19},{38,21},{33,23},{16,48}};
		BruteForceClosestPoints(p);
	}
	/* 
	 * 蛮力法求平面中距离最近的两点
	 * 
	 * 分别计算每一对之间的距离,然后找到距离最小的那一对，只考虑i<j的那些对(pi,pj)
	 * 输入：一个n个点的列表p
	 * 输出：两个最近点的距离
	 * 
	 */
	public double BruteForceClosestPoints(int[][] p)
	{
		double dist = 0;
		double d = Double.POSITIVE_INFINITY;
		int dim = 0,din = 0, djm = 0, djn = 0;
		int i, j;
		for(i = 0; i <= p.length - 1; i++)
		{
			for(j = i + 1; j <= p.length; j++)
			{
				dist = (p[i][0] - p[j][0])^2 + (p[i][1] - p[j][0])^2;
				d = Math.min(d, Math.sqrt(dist));
				if(d == Math.sqrt(dist))
				{
					dim = p[i][0];
					din = p[i][1];
					djm = p[j][0];
					djn = p[j][1];
				}
				
			}
		}
		System.out.println("平面中距离最近的两点为"+"("+dim+","+din+"),("+djm+","+djn+")");
		return d;
	}
}
