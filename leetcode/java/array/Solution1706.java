package leetcode.java.array;

public class Solution1706 {
    public int[] findBall(int[][] grid) {
        int k= grid.length;
        int p= grid[0].length;
        int a[]=new int[p];
        for(int i=0;i<p;i++)
        {
            int m=i,l=0;
            for(int j=0;j<k;j++)
            {
                l=m+grid[j][m];
                if(l<0 || l>=p || grid[j][m] != grid[j][l])
                {
                    m=-1;
                    break;
                }
                m=l;
            }
            a[i]=m;
        }
        return a;
    }
}
