package edu.princeton.cs.algs4;

public class ex1_2_10
{
    public static void main(String[] args)
    {
        VisualCounter10 a = new VisualCounter10("test",10,5);
        a.increment();
        a.increment();
        a.increment();
        a.increment();
        a.decrement();
        //a.decrement();
        System.out.print(a);
    }
}

public class VisualCounter10//Counter
{
    private final String name;
    private final int N;//允许运行的次数。
    private int n=0;
    private final int max;//count的绝对值的最大值。
    private int absvalue=0;
    private int count = 0;

    public VisualCounter10(String id,int N,int max)
    {
        name = id;
        this.N = N;
        this.max = max;
    }

    public void increment()
    {
        if(n<=N&&Math.abs(count)<=max)
        {
            count++;
            n++;
            //作图
            double x = 1.0/N*n;
            double y = (double)count/2.0;
            double rh = count/2.0;
            double rw = 0.3/N;
            StdDraw.setXscale(-0.5,1.5);
            StdDraw.setYscale(-(double)max,(double)max);
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }

    public void decrement()
    {
        if(n<=N&&Math.abs(count)<=max)
        {
            count--;
            n++;
            //作图
            double x = 1.0/N*n;
            double y = (double)count/2.0;
            double rh = count/2.0;
            double rw = 0.3/N;
            StdDraw.setXscale(-0.5,1.5);
            StdDraw.setYscale(-(double)max,(double)max);
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }

    public int tally()
    {
        return count;
    }

    public String toString()
    { return count + " " + name; }

    public static void main(String[] args)
    {
        System.out.print("a");
    }
}
