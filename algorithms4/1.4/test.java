public class test{
    public static void main(String[] args){
        int[] a = new int[3];
        int[] c = new int[3];
        for(int i=0;i<3;i++){
            a[i]=i;
        }
        int[] b = a;
        a = c;
        System.out.print(b[1]);
        System.out.print(a[1]);
    }
}