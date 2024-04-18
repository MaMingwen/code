package edu.princeton.cs.algs4;

public class DoublingRatio{
    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i]=StdRandom.uniform(-MAX,MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args){
        double prev = timeTrial(125);
        for(int N=250;true;N+=N){
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f",N,time);
            StdOut.printf("%5.1f \n",time/prev);
            prev = time;
        }
    }
}

public class Stopwatch{
    private final long start;
    public Stopwatch(){
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now-start) / 1000.0;
    }
}

public class ThreeSum{
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    if(a[i]+a[j]+a[k]==0){cnt++;}
                }
            }
        }
        return cnt;
    }
}