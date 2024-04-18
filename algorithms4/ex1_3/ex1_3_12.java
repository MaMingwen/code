import java.util.Iterator;

public class test{

    static Stack<String> copy(Stack<String> c){
        Stack<String> a = new Stack<String>();
        Stack<String> b = new Stack<String>();
        for(String s:c){
            a.push(s);
        }
        for(String s:b){
            b.push(s);
        }
    }

}

public class Stack<Item> implements Iterable<Item>{
    private Node first; // 栈顶（最近添加的元素）
    private int N; // 元素数量
    private class Node
    { // 定义了结点的嵌套类
    Item item;
    Node next;
    }
    public boolean isEmpty() { return first == null; } // 或：N == 0
    public int size() { return N; }
    public void push(Item item)
    { // 向栈顶添加元素
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
    }
    public Item pop()
    { // 从栈顶删除元素
    Item item = first.item;
    first = first.next;
    N--;
    return item;
    }

    public Item peek(){
        return first.item;
    }
    // iterator() 的实现请见算法 1.4
    // 测试用例 main() 的实现请见本节前面部分
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){

        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}