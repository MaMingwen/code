public class exercises_1_1_24
{

    public static int gcd(int p, int q)
    {
        Global.p = p;
        Global.q = q;
        Global.i++;
        System.out.printf("%d  p:%d,q:%d\n",Global.i,Global.p,Global.q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args)
    {
        int p = 0;
        int q = 0;
        p = Integer.parseInt(args[0]);
        q = Integer.parseInt(args[1]);
        System.out.println("1.1.24:");
        System.out.printf("%d",gcd(p,q));
        System.out.print("1.1.27:(用空间换时间)");
        //System.out.printf("%f",binomial(100,50,0.25));
        Double[][] dp = new Double[101][51];
        System.out.printf("%10.10f",binomial_chatgpt(100,50,0.25,dp));
    }

    public static double binomial(int N, int k, double p)
    {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }

    public static double binomial_chatgpt(int N, int k, double p, Double[][] dp)
    {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        if (dp[N][k] == null)
        {
        dp[N][k] = (1.0 - p)*binomial_chatgpt(N-1, k, p, dp) + p*binomial_chatgpt(N-1, k-1, p, dp);
        }
        return dp[N][k];
    }

}

public class Global
{
    public static int p;
    public static int q;
    public static int i;
}