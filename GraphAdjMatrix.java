
class GraphAdjMatrix extends GraphCommon implements Graph
{
    private int adjMatrix[][] = new int[MAX_SIZE][MAX_SIZE];
    
    public GraphAdjMatrix(){
        int i, j;
        for(i=0; i<MAX_SIZE; i++)
            for(j=0; j<MAX_SIZE; j++)
                this.adjMatrix[i][j] = 0;
    }
    
    public void einfKante( int v1, int v2) {
        this.adjMatrix[v1][v2] = 1;
        this.adjMatrix[v2][v1] = 1;
    }
    
    public Util.LinkedList<Integer[]> listKanten()
    {
        Util.LinkedList<Integer[]> kanten = new Util.LinkedListSingleChained<Integer[]>();
        
        int i, j;
        for(i=0; i<MAX_SIZE; i++)
            for(j=0; j<MAX_SIZE; j++)
                if(this.adjMatrix[i][j] == 1)
                    kanten.append( new Integer[] {i, j} );
        
        return kanten;
    }
    
    public int getAdjUnvisitedVertex( int v) {
        for(int i=0; i<nVerts; i++) {
            if(adjMatrix[v][i]==1 && vertList[i].wasVisited==false)
                return i;
        }

        return -1;     
    }
    
}