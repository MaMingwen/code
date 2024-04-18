package edu.princeton.cs.algs4;

public class ex1_2_2
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Interval1D[] a = new Interval1D[N];
        double l = 0.0;
        double r = 0.0;
        for(int i=0;i<N;i++)
        {
            if(!StdIn.isEmpty())
            {
                l = StdIn.readDouble();
                r = StdIn.readDouble();
                a[i] = new Interval1D(l,r);
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                if(a[i].intersects(a[j]))
                {
                    System.out.println(a[i]+"与"+a[j]+"相交");
                }
            }
        }
    }
}