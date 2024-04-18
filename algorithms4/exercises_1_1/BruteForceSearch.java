package edu.princeton.cs.algs4;
import java.util.Arrays;


public class BruteForceSearch
{

    public static int BruteForceSearch(int key,int[] a)
    {
        for (int i = 0; i < a.length; i++)
        if (a[i] == key) return i;
        return -1;
    }

    public static int rank_B(int key, int[] a)
    { // 数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) hi = mid - 1;
        else if (key > a[mid]) lo = mid + 1;
        else return mid;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        long stime_B = System.currentTimeMillis();
        //Arrays.sort(whitelist);
        while (!StdIn.isEmpty())
        { // 读取键值，如果不存在于白名单中则将其打印
        int key = StdIn.readInt();
        if (BruteForceSearch(key, whitelist) < 0)
        StdOut.println(key);
        }
        long etime_B = System.currentTimeMillis();
        System.out.printf("%d",etime_B-stime_B);
    }
}