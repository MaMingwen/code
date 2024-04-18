package edu.princeton.cs.algs4;

public class exercises_1_1
{
    public static void main(String[] args)
        {
            System.out.println("1.1.1 (a) :");
            System.out.println((0+15)/2);
            System.out.println("1.1.1 (b) :");
            System.out.println(2.0e-6 * 100000000.1);
            System.out.println("1.1.1 (c) :");
            System.out.println(true && false || true && false);


            System.out.println("1.1.2 (a) :");
            System.out.println((1 + 2.236)/2);
            System.out.println("1.1.2 (b) :");
            System.out.println(1 + 2 + 3 + 4.0);
            System.out.println("1.1.2 (c) :");
            System.out.println(4.1 >= 4);
            System.out.println("1.1.2 (d) :");
            System.out.println(1 + 2 + "3");


            System.out.println("1.1.3");
            if (Integer.parseInt(args[0]) == Integer.parseInt(args[1]) && Integer.parseInt(args[1]) == Integer.parseInt(args[2]))
                {
                    System.out.print("equal");
                }
            else
                {
                    System.out.print("not equal");
                }
            

            System.out.println("1.1.4 (a) :");
            System.out.println("问题是在java语法中'then'不存在");
            System.out.println("1.1.4 (b) :");
            System.out.println("问题是if语句后面缺小括号");
            System.out.println("1.1.4 (c)(d) :");
            System.out.println("都没有问题");


            System.out.println("1.1.5");
            double x = Math.random() * 10;
            double y = Math.random() * 10;
            if ((0 <= x && x <= 1) && (0 <= y && y <= 1))
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }


            System.out.println("1.1.6");
            System.out.println("斐波拉契数列的前15项(从0开始)");
            int f = 0;
            int g = 1;
            for (int i = 0; i <= 15; i++)
                {
                StdOut.println(f);
                f = f + g;
                g = f - g;
                }

            System.out.println("1.1.7");
            double t = 9.0;
            while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
            StdOut.printf("%.5f\n", t);


            int sum = 0;
            for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
            sum++;
            StdOut.println(sum);

            System.out.println('b');
            System.out.println('b' + 'c');
            System.out.println((char) ('a' + 4));
        }
}