abstract class GraphCommon
{
    public static final int MAX_SIZE = 20;
    
    public Knoten vertList[] = new Knoten[MAX_SIZE];
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
        new GraphTest((Graph)this, "Graph Visualizer");
    }
    
    public Graph dfs()
    {
        Util.Stack<Integer> theStack = new Util.StackLinkedList<Integer>();
        
        Graph search = new GraphAdjMatrix();
        ((GraphAdjMatrix)search).vertList = this.vertList;
        
        theStack.push(0);
        vertList[0].wasVisited = true;
//         this.vertList[start].display();
        
        int lastVisited=0;
        
        while( !theStack.isEmpty() )
        {
            int v2 = getAdjUnvisitedVertex( theStack.peek() );
            if( v2 == -1 ) {
                theStack.pop();
            }
            else {
                vertList[v2].wasVisited = true;
                search.einfKante( lastVisited, v2 );
                lastVisited = v2;
//                 vertList[v2].display();
                theStack.push(v2);
            }      
        }
        
        for(int i=0; i<nVerts; i++)
            vertList[i].wasVisited = false;
        
        return search;
    }
    
    public Graph bfs()
    {
        Util.Queue<Integer> theQueue = new Util.QueueLinkedList<Integer>();
        
        Graph search = new GraphAdjMatrix();
        ((GraphAdjMatrix)search).vertList = this.vertList;
        
        theQueue.enqueue(0);
        vertList[0].wasVisited = true;
//         vertList[0].display();
        int lastVisited=0;
        
        while( theQueue.getLength() > 0 )
        {
            int v1 = theQueue.dequeue();
            while( true )
            {
                int v2 = getAdjUnvisitedVertex( v1 );
                if(v2 == -1) 
                    break;
                else {
                    vertList[v2].wasVisited = true;
                    search.einfKante( lastVisited, v2);
                    lastVisited = v2;
//                     vertList[v2].display();
                    theQueue.enqueue(v2);
                }
            }
        }
        
        for(int i=0; i<this.nVerts; i++)
            this.vertList[i].wasVisited = false;
        
        return search;
    }
}

