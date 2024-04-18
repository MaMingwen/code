public class Rational
{
    private final int numerator;
    private final int denominator;

    public Rational(int numerator,int denominator)
    {
        this.numerator = (int)(numerator/(double)gcd(numerator,denominator));
        this.denominator = (int)(denominator/(double)gcd(numerator,denominator));
    }

    public int gcd(int a,int b)
    {
        int r = a%b;
        if(r==0)
        {
            return b;
        }
        else
        {
            return gcd(b,r);
        }
    }

    public Rational plus(Rational b)
    {
        return new Rational(this.numerator*b.denominator+this.denominator*b.numerator,this.denominator*b.denominator);
    }

    public Rational minus(Rational b)
    {
    
    }

    public boolean equals(Object that)
    {
        if(this == that) return true;
        if(that == null) return false;
        Rational a = (Rational) that;
        if(this.numerator!=a.numerator) return false;
        if(this.denominator!=a.denominator) return false;
        return true;
    }

    public String toString()
    {
        return String.format("numerator:%d,denominator:%d",this.numerator,this.denominator);
    }

    

}