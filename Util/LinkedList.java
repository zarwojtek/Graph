package Util;

import java.util.Iterator;

public interface LinkedList<T> extends Iterable<T>
{
    public void append( T elem);
    public void remove( int n);
    public T getElement( int n);
    public int getLength();
    public Iterator<T> iterator();
}


