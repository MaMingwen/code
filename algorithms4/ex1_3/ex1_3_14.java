public class ResizingArrayQueueOfStrings{
    //用固定长度的数组实现队列抽象
    private String[] a;
    private int N;//队列的实际容量
    public ResizingArrayQueueOfStrings(int cap){
        a = new String[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void enqueue(String s){
        if(N==a.length()&&N>0) resize(2*a.length());
        a[N++] = s;
    }
    public String dequeue(String s){
        String t = a[0];
        a[0]=null;
        for(int i=0;i<--N;i++){
            a[i]=a[i+1];
        }
        if(N==(int)(a.length()/4)&&N>0) resize((int)(a.length()/2));
        return t;
    }
    public int size(){
        return N;
    }
    private void resize(int max){
        String[] temp = new String[max];
        for(i=0;i<N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
}