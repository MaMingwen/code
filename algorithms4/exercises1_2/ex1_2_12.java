package edu.princeton.cs.algs4;
import java.util.Arrays;

public class ex1_2_12
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        SmartDate a = new SmartDate(m,d,y);
        System.out.println(a);
        System.out.println(a.dayOfTheWeek());
    }
}


public class SmartDate
{
    private final int month;
    private final int year;
    private final int day;
    String[] bigmonth = {"1","3","5","7","8","10","12"};
    String[] smallmonth = {"4","6","9","11"};
    public SmartDate(int m, int d, int y) 
    {
        month = m; day = d; year = y;
        if(Arrays.asList(bigmonth).contains(m+"")&&(d>31))
        {
            throw new IllegalArgumentException("日期不能超过三十一天。");
        }
        else if(Arrays.asList(smallmonth).contains(m+"")&&(d>30))
        {
            throw new IllegalArgumentException("小月不能超过三十天。");
        }
        else if(month==2&&checkrunnian(year)&&(d>29))
        {
            throw new IllegalArgumentException("闰年二月不能超过二十九天。");
        }
        else if(month==2&&!checkrunnian(year)&&(d>28))
        {
            throw new IllegalArgumentException("非闰年二月不能超过二十八天。");
        }
    }
    public boolean checkrunnian(int yearb)
    {
        if(yearb%4==0)
        {
            if(yearb%100==0)
            {
                if(yearb%400==0)
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

    public String dayOfTheWeek()
    {
        String[] week = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        int days = 0;
        int weekindex = 0;
        for(int i=2000;i<year;i++)
        {
            if(checkrunnian(i))
            {
                days = days + 366;
            }
            else
            {
                days = days +365;
            }
        }
        for(int i=1;i<month;i++)
        {
            //System.out.printf("%b",Arrays.asList(bigmonth).contains(i+""));
            if(Arrays.asList(bigmonth).contains(i+""))
            {
                days = days + 31;
            }
            else if(Arrays.asList(smallmonth).contains(i+""))
            {
                days = days +30;
            }
            else if((checkrunnian(year))&&(i==2))
            {
                days = days +29;
            }
            else if((!checkrunnian(year))&&(i==2))
            {
                days = days + 28;
            }
        }
        days = days + day - 1;
        weekindex = days%7;
        return week[weekindex];
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