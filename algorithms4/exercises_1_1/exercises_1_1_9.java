public class exercises_1_1_9
{
    public static void main(String[] args)
    {
        //1.1.9的解答
        int N = Integer.parseInt(args[0]);
        int n = 0;
        String b = "";
        if (N == 0)
        {
            System.out.print("0");
        }
        else if (N == 1)
        {
            System.out.print("1");
        }
        else
        {
            //首先求出二进制表示的位数。
            int i = 0;
            while(n < N)
            {
            n = 0;
            i++;
            n = N%((int)Math.pow(2,i));
            }
            //j是2进制表示的位数。
            int j = i;
            int[] a;
            a = new int[j];
            for(int k = 0; k < j; k++)
            {
                a[k] = 0;
            }
            a[j-1] = 1;

            N = N - (int)Math.pow(2,(j-1));
            //再把N分解成2的某次方之和
            while(N > 1)
            {
                i = 0;
                n = 0;
                while(n < N)
                    {
                    n = 0;
                    i++;
                    n = N%((int)Math.pow(2,i));
                    }

                a[i-1] = 1;

                N = N - (int)Math.pow(2,i-1);
            }
            //最后考虑最小项是1还是0
            if (N == 1)
            {
                a[0] = 1;
            }
            else
            {
                a[0] = 0;
            }
            //转换为字符串，输出结果
            for(int k = j-1; k >= 0; k--)
                b = b + a[k];
            System.out.print(b);
        }

        System.out.print("1.1.10已解答。");


        System.out.println("1.1.11:");
        boolean[][] b11 = {{true,true},{false,false}};
        print_bool(b11);


        System.out.print("\n");
        System.out.println("1.1.12:");
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);


        System.out.println("1.1.13很简单，略过。");


        System.out.println("1.1.14:");
        System.out.print(lg(Integer.parseInt(args[1])));


        System.out.println("1.1.15:");
        int[] a15 = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1};
        int M = 8;
        int[] b15 = histogram(a15, M);
        for(int i15 = 0;i15 < M;i15++)
            System.out.printf("%d",b15[i15]);

        System.out.println("1.1.16:");
        System.out.print(exR1(6));


        System.out.println("1.1.17:已经回答");


        System.out.println("1.1.18:");
        System.out.println(mystery(2,25));
        System.out.println(mystery(3,11));

        System.out.println("1.1.19:");
        long[] F19 = new long[100];
        for(int i19 = 0;i19 <100;i19++)
            F19[i19] = 0;
        
        F19[1] = 1;
        for(int j19 = 2;j19<100;j19++)
            {
            F19[j19] = F19[j19-1] + F19[j19 - 2];
            System.out.println(j19 +" "+ F19[j19]);
            }

        System.out.println("1.1.20:");
        System.out.println(ln20(10));
        System.out.println(Math.log(10.0*9*8*7*6*5*4*3*2));

    }


    public static void print_bool(boolean[][] a)
    {
        int ro = a.length;
        int co = a[0].length;
        for(int i = 0; i < ro+1; i++)
        {
            if(i == 0)
            {
                System.out.print("____");
                for(int j1 = 1; j1 < co+1; j1++)
                    System.out.printf("第%d列 ", j1);
                System.out.print("\n");
            }
            else
            {
                System.out.printf("第%d行 ", i);
            
                for(int j2 = 0; j2 < co; j2++)
                {
                    if (a[i-1][j2])
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
        }
        
    }

    public static int lg(int a)
    {
        if (a < 0)
        {
            return -1;
        }
        else if (a == 1)
        {
            return 0;
        }
        else
        {
            int test = 1;
            int i = 0;
            while(test < a)
            {
                test = 2 * test;
                i++;
            }
            return i-1;
        }
    }


    public static int[] histogram(int[] a, int M)
    {
        int N = a.length;
        int[] b = new int[M];
        for (int m =0; m < M; m++)
        {
            b[m] = 0;
        }
        for (int m = 0; m < M; m++)
        {
            for (int n = 0; n < N; n++)
            {
                if(a[n] == m)
                {
                    b[m]++;
                }
            }
        }
        return b;
    }

    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    public static int mystery(int a, int b)
    {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    public static double ln20(int N)
    {
        if (N == 1)
            return 0;
        else
        {
            double n = (double)N;
            return ln20(N-1) + Math.log(n);
        }
        
    }
}