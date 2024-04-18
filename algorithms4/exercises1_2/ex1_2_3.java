package edu.princeton.cs.algs4;
import java.util.Arrays;

public class ex1_2_3
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        double[] a1 = new double[2];
        double[] a2 = new double[2];
        Interval1D[] x = new Interval1D[N];
        Interval1D[] y = new Interval1D[N];

        Interval2D[] b = new Interval2D[N];
        for(int i=0;i<N;i++)
        {
            a1[0] = StdRandom.uniform(min,max);
            a1[1] = StdRandom.uniform(min,max);
            a2[0] = StdRandom.uniform(min,max);
            a2[1] = StdRandom.uniform(min,max);
            Arrays.sort(a1);
            Arrays.sort(a2);
            x[i] = new Interval1D(a1[0],a1[1]);
            y[i] = new Interval1D(a2[0],a2[1]);
            b[i] = new Interval2D(x[i],y[i]);
            b[i].draw();
        }

        int intersect = 0;
        int contain = 0;

        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                if(b[i].intersects(b[j]))
                intersect++;
            }
        }

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(contain1D(x[j],x[i])&&contain1D(y[j],y[i]))
                {
                    contain++;
                    break;
                }
            }
        }

        System.out.printf("intersect:%d,contain:%d",intersect,contain);

    }

    public static boolean contain1D(Interval1D a,Interval1D b)
    {
        //判断区间a 包含 区间b。
        double a1 = a.min();
        double a2 = a.max();

        double b1 = b.min();
        double b2 = b.max();

        if(b1>a1&&b2<a2)
            return true;
        else
            return false;
    }
}