package Util;

public interface Stack<T>
{
    public boolean isEmpty();
    public void push( T elem);
    public T pop();
    public T peek();
}
