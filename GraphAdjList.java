
class GraphAdjList extends GraphCommon implements Graph
{
    private AdjList adjList = new AdjList();
    
    public void einfKante( int v1, int v2) {
        adjList.addEdge(v1, v2);
        adjList.addEdge(v2, v1);
    }
    
    public Util.LinkedList<Integer[]> listKanten()
    {
        Util.LinkedList<Integer[]> kanten = new Util.LinkedListSingleChained<Integer[]>();
        
        for(int i=0; i<nVerts; i++) 
            for(int j : adjList.lists[i])
                kanten.append( new Integer[] {i, j} );
        
        return kanten;
    }
    
    public int getAdjUnvisitedVertex( int v) 
    {
        for(int adjv : adjList.lists[v])
            if( !vertList[adjv].wasVisited )
                return adjv;
        
        return -1;
    }
}