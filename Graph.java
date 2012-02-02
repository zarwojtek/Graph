
interface Graph
{
    public void einfKnoten( Knoten kn);
    public void einfKante( int v1, int v2);
    public Knoten[] listKnoten();
    
    public int getAdjUnvisitedVertex( int v);
    public void dfs();
}



