package Util;


public class LinkedListSingleChained<T> implements LinkedList<T>
{
    class Node<T>
    {
        public T elem;
        public Node next;
        
        public Node(T elem) {
            this.elem = elem;
            this.next = null;
        }
    }
    
    public int length;
    private Node<T> head_dummy;
    private Node<T> tail_dummy;
    
    public LinkedListSingleChained()  {
        this.length = 0;
        this.head_dummy = new Node<T>(null);
        this.tail_dummy = new Node<T>(null);
    }
    
    private Node<T> getnNode(int n) {
        if( n<0 || n>length)
            return null;
        else {
            Node<T> cur = tail_dummy.next;
            for(int i=0; i<n; i++)
                cur = cur.next;
            return cur;
        }
    }
    
    public T getElement( int n) {
        return getnNode(n).elem;
    }

    
    public void append( T elem) {
        Node<T> tmp = new Node<T>(elem);
        
        if(length==0)
            tail_dummy.next = tmp;
        else {
            getnNode(length-1).next = tmp;
        }
        tmp.next = head_dummy;
        
        length++;
    }
    
    public void remove( int n) {
        
        Node<T> to_rm = getnNode(n);
        Node<T> bef = getnNode(n-1);
        
        if(bef == null)
            tail_dummy.next = to_rm.next;
        else
            bef.next = to_rm.next;
            
        to_rm.next = null;
        
        this.length--;
    }
    
}
