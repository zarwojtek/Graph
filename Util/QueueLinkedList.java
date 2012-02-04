package Util;

public class QueueLinkedList<T> implements Queue<T>
{
    private LinkedList<T> data = new LinkedListSingleChained<T>();
    
    public void enqueue( T elem) {
        data.append(elem);
    }
    
    public T dequeue() {
        T val = data.getElement(0);
        data.remove(0);
        return val;
    }
    
    public int getLength() {
        return data.getLength();
    }

}
