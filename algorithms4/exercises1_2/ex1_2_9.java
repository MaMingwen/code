package edu.princeton.cs.algs4;
import java.util.Arrays;

public class BinarySearch
{
public static int rank(int key, int[] a,Counter times)
{ // 数组必须是有序的
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    { // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
        int mid = lo + (hi - lo) / 2;
        times.increment();
        if (key < a[mid]) 
        {
            hi = mid - 1;
        }
        else if (key > a[mid]) 
        {
            lo = mid + 1;
        }
        else return mid;
    }
    return -1;
}
public static void main(String[] args)
{
    //添加一个计数器统计检索的次数
    Counter times = new Counter("times");
    int[] whitelist = In.readInts(args[0]);
    Arrays.sort(whitelist);
    while (!StdIn.isEmpty())
    { // 读取键值，如果不存在于白名单中则将其打印
        int key = StdIn.readInt();
        Counter a = new Counter(key + "'s Counter");
        if (rank(key, whitelist,a) < 0)
        {
            StdOut.println(key);
        }
        StdOut.println(a);
    }
}
}