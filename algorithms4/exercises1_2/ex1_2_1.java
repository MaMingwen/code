package edu.princeton.cs.algs4;

public class ex1_2_1
{
    public static void main(String[] args)
    {
        int N = 0;
        N = Integer.parseInt(args[0]);
        Point2D[] a = new Point2D[N];
        //初始化二维点组成的对象数组
        for(int i=0;i<N;i++)
        {
            double x = StdRandom.random();
            double y = StdRandom.random();
            a[i] = new Point2D(x,y);
        }

        double dis = a[0].distanceTo(a[1]);
        int[] points = new int[2];

        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                if(a[i].distanceTo(a[j])<dis) 
                {
                    dis = a[i].distanceTo(a[j]);
                    points[0]=i;
                    points[1]=j;
                }
            }
        }

        System.out.printf("最短距离为：%f\n对应的点的序号为：%d,%d\n",dis,points[0],points[1]);
        System.out.println(a[points[0]]);
        System.out.println(a[points[1]]);
        
    }
}