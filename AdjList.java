 

class AdjList
{
    public Util.LinkedListSingleChained<Integer>[] lists = 
        new Util.LinkedListSingleChained[GraphCommon.MAX_SIZE];
    
    public AdjList() {
        int i;
        for(i=0; i<this.lists.length; i++)
            this.lists[i] = new Util.LinkedListSingleChained<Integer>();
    }
    
    public void addEdge( int v1, int v2) {
        this.lists[v1].append(v2);
    }   
}

