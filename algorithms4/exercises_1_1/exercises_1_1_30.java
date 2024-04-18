package edu.princeton.cs.algs4;

public class exercises_1_1_30
{
    public static void main(String[] args)
    {
        int N = 0;
        double p = 0.0;
        N = Integer.parseInt(args[0]);
        Boolean[][] a = new Boolean[N][N];
        for(int i = 0;i<N;i++)
            {for(int j = 0;j<N;j++)
                {if(gcd(i,j) == 1)
                    a[i][j] = true;
                else
                    a[i][j] = false;
                System.out.printf("%b ",a[i][j]);}
            System.out.print("\n");}
        p = Double.parseDouble(args[1]);
        double l = Double.parseDouble(args[2]);
        double r = Double.parseDouble(args[3]);
        //plot31(N,p);
        plot32(N,l,r);
    }

    public static int gcd(int i,int j)
    {
        if(j == 0) return i;
        else return gcd(j, i%j);
    }

    public static void plot31(int N,double p)
    {
        double[] x = new double[N];
        double[] y = new double[N];
        StdDraw.setXscale(-1.5,1.5);
        StdDraw.setYscale(-1.5,1.5);
        StdDraw.circle(0.0,0.0,1.0);//单位圆。
        for(int i = 0;i<N;i++)
        {
            StdDraw.setPenRadius(0.01);
            StdDraw.point(Math.cos(2*Math.PI/N*i),Math.sin(2*Math.PI/N*i));
            x[i] = Math.cos(2*Math.PI/(N)*i);
            y[i] = Math.sin(2*Math.PI/(N)*i);
        }
        for(int j = 0;j<N;j++)
        {
            for(int k = 0;k<j;k++)
            if(StdRandom.bernoulli(p)) 
                {
                    StdDraw.setPenRadius(0.005);
                    /*StdDraw.setPenColor(Color.GRAY);*/
                    StdDraw.line(x[j],y[j],x[k],y[k]);
                }
        }
    }

    public static void plot32(int N,double l,double r)
    {
        int[] a = new int[N];
        double b = 0.0;
        for(int i = 0;i<N;i++)
        {
            a[i] = 0;
        }
        while(!StdIn.isEmpty())
        {
            b = StdIn.readDouble();
            for(int j = 0;j<N-1;j++)
            {
                if((b<=(j+1.0)/N*(r-l)+l) && (b>(double)j/N*(r-l)+l))
                {
                    a[j]++;
                }
            }
            if((b<r) && (b>((N-1.0)/N*(r-l)+l)))
            {
                a[N-1]++;
            }
        }
        System.out.printf("%d,%d",a[0],a[1]);
        for (int k = 0; k < N; k++)
        {
            double x = 1.0*k/N;
            double y = a[k]/2.0;
            double rw = 0.3/N;
            double rh = a[k]/2.0;
            StdDraw.setXscale(-0.5,1.5);
            StdDraw.setYscale(0.0,(double)N*1.5);
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}