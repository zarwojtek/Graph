
class GraphAdjList extends GraphCommon implements Graph
{
    private AdjList adjList = new AdjList();
    
    public void einfKante( int v1, int v2) {
        adjList.addEdge(v1, v2);
        adjList.addEdge(v2, v1);
    }
    
    public int getAdjUnvisitedVertex( int v) {
        Util.LinkedListSingleChained<Integer> list = this.adjList.lists[v];
        
        for(int i=0; i<list.length; i++) {
            int v2 = list.getElement(i);
            if( vertList[v2].wasVisited==false )
                return v2;
        }
        return -1;
    }
}