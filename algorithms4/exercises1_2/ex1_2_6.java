package edu.princeton.cs.algs4;

public class ex1_2_6
{
    public static void main(String[] args)
    {
        System.out.printf("%b",checkCircular(args[0],args[1]));
    }

    public static boolean checkCircular(String a,String b)
    {
        return a.length()==b.length()&&((a+a).indexOf(b)!=-1);
    }
}