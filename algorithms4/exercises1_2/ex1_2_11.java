package edu.princeton.cs.algs4;
import java.util.Arrays;

public class ex1_2_11
{
    public static void main(String[] args)
    {
        SmartDate a = new SmartDate(2,29,2000);
        System.out.print(a);
    }
}


public class SmartDate
{
    private final int month;
    private final int year;
    private final int day;
    int[] bigmonth = {1,3,5,7,8,10,12};
    int[] smallmonth = {4,6,9,11};
    public SmartDate(int m, int d, int y) 
    {
        month = m; day = d; year = y;
        if(Arrays.asList(bigmonth).contains(m)&&d>31)
        {
            throw new IllegalArgumentException("日期不能超过三十一天。");
        }
        if(Arrays.asList(smallmonth).contains(m)&&d>30)
        {
            throw new IllegalArgumentException("小月不能超过三十天。");
        }
        if(month==2&&checkrunnian(month)&&d>29)
        {
            throw new IllegalArgumentException("闰年二月不能超过二十九天。");
        }
        if(month==2&&!checkrunnian(month)&&d>28)
        {
            throw new IllegalArgumentException("闰年二月不能超过二十八天。");
        }
    }
    public boolean checkrunnian(int month)
    {
        if(month%4==0)
        {
            if(month%100==0)
            {
                if(month%400==0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
    public int month()
    { return month; }
    public int day()
    { return day; }
    public int year()
    { return year; }
    public String toString()
    { return month() + "/" + day()+ "/" + year(); }
}