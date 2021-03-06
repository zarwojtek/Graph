
interface Graph
{
    public void einfKnoten( Knoten kn);
    public void einfKante( int v1, int v2);
    public Knoten[] listKnoten();
    public Util.LinkedList<Integer[]> listKanten();
    
    public int getAdjUnvisitedVertex( int v);
    public Graph dfs();
    public Graph bfs();
    
    public void visualize();
}



