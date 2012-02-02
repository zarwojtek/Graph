
class Knoten<T>
{
    private T knElem;
    public boolean wasVisited;
    
    public Knoten ( T elem) {
        this.knElem = elem;
        this.wasVisited = false;
    }

    public T getElement() {
        return this.knElem;
    }
    
    public void display() {
        System.out.println( this.getElement() );
    }
}
