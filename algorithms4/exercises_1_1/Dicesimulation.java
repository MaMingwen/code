package edu.princeton.cs.algs4;

public class Dicesimulation
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        //int M = 0;
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
        for (int j = 1; j <= SIDES; j++)
        dist[i+j] += 1.0;
        for (int k = 2; k <= 2*SIDES; k++)
        dist[k] /= 36.0;

        double[] a = new double[11];
        double test = -1.0;//test存储实验频率。
        double epsilon = 0.001;
        int n = 1;
        for(int m = 0;m<11;m++)
        {
            a[m] = 0.0;
        }
        int test1 = 0;
        int test2 = 0;
        //for(int n = 1;n<=N;n++)
        while(!estimate(test,dist[test1+test2],epsilon))
        {
            test1 = StdRandom.uniform(1,7);
            test2 = StdRandom.uniform(1,7);
            for(int l = 0;l<11;l++)
            {
                if(test1 + test2 == l+2) a[l] = a[l] + 1.0;
            }
            test = a[test1+test2-2]/((double)n);
            System.out.printf("第%d次实验,实验结果：%d,对应频率%f,真实概率：%f\n",n,test1+test2,a[test1+test2-2]/((double)n),dist[test1+test2]);
            n++;
        }
        for(int n1 = 0;n1<11;n1++)
        {
            a[n1] /= (double)N;
        }
    }

    public static boolean estimate(double a,double b,double epsilon)
    {
        if(Math.abs(a - b) < epsilon) return true;
        else return false;
    }

}