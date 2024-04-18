public class Matrix()
{
    public static void main()
    {

    }

    //向量点积
    public static double dot(double[] x,double[] y)
    {
        if(!(x.length == y.length))
        {
            System.out.println("输入的向量长度不同。");
        }
        double z = 0.0;
        for(int i = 0;i<x.length;i++)
        {
            z += x[i]*y[i];
        }
        return z;
    }

    //矩阵乘法
    public static double[][] mult(double[][] a,double[][] b)
    {
        double[][] c = new double[a.length][b[0].length];

        for(int m = 0;m<a.length;m++)
        {
            for(int n = 0;n<b[0].length;n++)
            c[m][n] = 0.0;
        }
        if(!(a[0].length == b.length))
        {
            System.out.println("输入的矩阵尺寸异常");
        }
        for(int i = 0;i<a.length;i++)
        {
            for(int j = 0;j<b[0].length;j++)
            {
                for(int k = 0;k<a[0].length;k++)
                {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }

    public static double[][] transpose(double[][] a)
    {

    }
    public static double[] mult(double[][] a,double[] x)
    {

    }
    public static double[] mult(double[] x,double[][] a)
    {
        
    }
}