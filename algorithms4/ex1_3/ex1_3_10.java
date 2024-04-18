package edu.princeton.cs.algs4;


public class InfixtoPostfix{
    public static void main(String[] args){
        Stack<String> expr = new Stack<String>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(!s.equals(")")){
                expr.push(s);
            }
            else{
                String right = expr.pop();
                String middle = expr.pop();
                String left = expr.pop();
                String leftbracket = expr.pop();
                String t = left+" "+right+" "+middle;
                expr.push(t); 
            }
        }
        System.out.println(expr.pop());
    }
}

public class Stack<Item>{
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
}