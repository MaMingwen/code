public class test{
    public static void main(String[] args){
        pass;
    }
}

public class test1{
    Node first = new Node();
    Node second = new Node();
    Node third = new Node();
    private class Node{
        Node next;
        String item;
    }
    public void delete(int k){
        Node s = first;
        for(int i=0;i<k-1;i++){
            s=s.next;
        }
        s.next=s.next.next;
    }
}