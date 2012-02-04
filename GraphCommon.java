abstract class GraphCommon
{
    public static final int MAX_SIZE = 20;
    
    protected Knoten vertList[] = new Knoten[MAX_SIZE];
    protected int nVerts = 0;
    
    public Knoten[] listKnoten() {
        return this.vertList;
    }

    public void einfKnoten( Knoten kn) {
        this.vertList[this.nVerts++] = kn;
    }
    
    abstract public int getAdjUnvisitedVertex(int v);
    
    public void visualize() 
    {
        new GraphTest((Graph)this);
    }
    
    public void dfs()
    {
        Util.Stack<Integer> theStack = new Util.StackLinkedList<Integer>();
        
        int start = 0;
        theStack.push(start);
        this.vertList[start].wasVisited = true;
        this.vertList[start].display();
        
        while( !theStack.isEmpty() )
        {
            int v2 = this.getAdjUnvisitedVertex( theStack.peek() );
            if( v2 == -1 ) {
                theStack.pop();
            }
            else {
                this.vertList[v2].wasVisited = true;
                this.vertList[v2].display();
                theStack.push(v2);
            }      
        }
        
        for(int i=0; i<this.nVerts; i++)
            this.vertList[i].wasVisited = false;
    }
    
    public void bfs()
    {
        Util.Queue<Integer> theQueue = new Util.QueueLinkedList<Integer>();
        
        int v1 = 0;
        theQueue.enqueue(v1);
        vertList[v1].wasVisited = true;
        vertList[v1].display();
        
        while( theQueue.getLength() > 0 )
        {
            v1 = theQueue.dequeue();
            while( true )
            {
                int v2 = getAdjUnvisitedVertex( v1 );
                if(v2 == -1) 
                    break;
                else {
                    vertList[v2].wasVisited = true;
                    vertList[v2].display();
                    theQueue.enqueue(v2);
                }
            }
        }
        
        for(int i=0; i<this.nVerts; i++)
            this.vertList[i].wasVisited = false;
    }

}

