public class test1{
    public static void main(String[] args){
        test a = new test();
        System.out.print(a.Dellast());
    }
}


public class test{
    private Node first = new Node();
    private Node second = new Node();
    private Node third = new Node();
    private Node s = new Node();
    private Node last = new Node();

    public String Dellast(){
        first.next = second;
        second.next = third;
        first.item = "first";
        second.item = "second";
        third.item = "third";
        last.item = "last";
        third.next = last;
        s = first;
        while(s!=null&&s.next!=null){
            if(s.next.next==null){
                s.next = s.next.next;
            }
            else{
                s = s.next;
            }
        }
        return s.item;
    }
    private class Node{
        Node next;
        String item;
    }
}