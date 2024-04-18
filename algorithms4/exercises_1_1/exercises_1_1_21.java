package edu.princeton.cs.algs4;

public class exercises_1_1_21
    {
        public static void main(String[] args)
        {
            String name = "未输入";
            int a = 0;
            int b = 0;
            double c = 0.0;
            while(!StdIn.isEmpty())
            {
                name = StdIn.readString();
                a = StdIn.readInt();
                b = StdIn.readInt();
                c = (double)a / b;
                System.out.printf(name);
                System.out.printf(" %d %d",a,b);
                System.out.printf(" %.3f",c);
                System.out.printf("\n");
            }

            System.out.println("1.1.22:");
            int[] a22 = {1, 2, 3};
            System.out.println(rank(1, a22));

        }
        public static int rank(int key, int[] a)
        {
            Depth22.depth22 = 0;
            return rank(key, a, 0, a.length - 1); }
        public static int rank(int key, int[] a, int lo, int hi)
        { //如果key存在于a[]中，它的索引不会小于lo且不会大于hi
            Depth22.depth22++;
            System.out.printf("%d,%d,%d \n",lo,hi,Depth22.depth22);
            if (lo > hi) return -1;
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) return rank(key, a, lo, mid - 1);
            else if (key > a[mid]) return rank(key, a, mid + 1, hi);
            else return mid;
        }
    }
    //通过这种方式引入全局变量，从而获得递归的深度。
    public class Depth22{
        public static int depth22 = 0;
    }