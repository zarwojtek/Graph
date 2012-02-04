package Util;

public interface Queue<T>
{
    public void enqueue( T elem);
    public T dequeue();
    public int getLength();
}
