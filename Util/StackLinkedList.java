package Util;


public class StackLinkedList<T> implements Stack<T>
{
    private LinkedList<T> list = new LinkedListSingleChained<T>();
    private int top;
    
    public StackLinkedList() {
        this.top = -1;
    }
    
    public void push(T elem){
        this.list.append(elem);
        this.top++;
    }
    
    public T pop() {
        T val;
        if( !this.isEmpty() ) {
            val = this.list.getElement(this.top);
            this.list.remove(this.top);
            this.top--;
            return val;
        }
        else
            return null;
    }
     
    public T peek() {
        return this.list.getElement(this.top);
    }
    
    public boolean isEmpty() {
        return this.top == -1;
    }
}