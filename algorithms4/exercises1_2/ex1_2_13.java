public class ex1_2_13
{
    public static void main(String[] args)
    {

    }
}

public class Transaction
{
    private final String who;
    private final double amount;
    private final Date when;
    
    public Transcation(String who,Date when,double amount)
    {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who()
    {
        return who;
    }

    public Date when()
    {
        return when;
    }
    
    public double amount()
    {
        return amount;
    }

    public boolean equals(Object that)
    {
        if(this = that) return true;
        if(that = null) return false;
        if(this.getClass() != that.getClass()) return false;
        Transaction x = (Transaction) that;
        if(this.who != x.who) return false;
        if(this.when != x.when) return false;
        if(this.date != x.date) return false;
        return true;
    }

    public int compareTo(Transaction that)
    {

    }

    public int hashCode()
    {

    }

    public Stirng toString()
    {
        return "amount:"+amount()+"\n"+"name:"+when()+"\n"+"date:"+when();
    }
}

public class Date
{
    private final int month;
    private final int day;
    private final int year;
    public Date(int m, int d, int y)
    { month = m; day = d; year = y; }
    public int month()
    { return month; }
    public int day()
    { return day; }
    public int year()
    { return year; }
    public String toString()
    { return month() + "/" + day()+ "/" + year(); }
    public boolean equals(Object x)
    {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Date that = (Date) x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }
}