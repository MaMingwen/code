package edu.princeton.cs.algs4;

public class ShuffTest
{
    public static void main(String[] args)
    {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        double[] a = new double[M];
        int[][] b = new int[M][M];
        for(int j = 0;j<M;j++)
        {
            a[j] = j;
        }

        for(int i = 0;i<N;i++)
        {
            shuffle(a);
            for(int n = 0;n<M;n++)
            {
                for(int m = 0;m<M;m++)
                {
                    if(n == a[m]) b[n][m]++;
                }
            }
            init(a);
        }

        for(int n = 0;n<M;n++)
        {
            for(int m = 0;m<M;m++)
            {
                System.out.printf("%d ",b[n][m]);
            }
            System.out.print("\n");
        }

    }

    public static void shuffle(double[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        { // 将 a[i] 和 a[i..N-1] 中任意一个元素交换
        int r = i + StdRandom.uniform(N-i);
        double temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        }
    }

    public static void shuffle_bad(double[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        { // 将 a[i] 和 a[i..N-1] 中任意一个元素交换
        int r = StdRandom.uniform(N);//仅有此处代码与shuffle不同
        double temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        }
    }

    public static double[] init(double[] a)
    {
        for(int i = 0;i<a.length;i++)
        {
            a[i] = i;
        }
        return a;
    }
}