import processing.core.*;


public class MyProcessingSketch extends PApplet
{
    private Graph g;
    
    private void buildGraph()
    {   
        g = new GraphAdjList();        

        g.einfKnoten( new Knoten<Character>('a') );
        g.einfKnoten( new Knoten<Character>('b') );
        g.einfKnoten( new Knoten<Character>('c') );
        g.einfKnoten( new Knoten<Character>('d') );
        g.einfKnoten( new Knoten<Character>('e') );
        
        g.einfKante(1,2); // b-c
        g.einfKante(3,4); // d-e
        g.einfKante(0,3); // a-d
        g.einfKante(3,2); // d-c
        
        for( Knoten kn : g.listKnoten() )
            if( kn != null) System.out.println(kn.getElement());
            
        System.out.println(g.getAdjUnvisitedVertex(0));

        g.dfs();

	}
    
    public void setup()
    {
        size(640, 480);
        
        buildGraph();
    }
    
    public void draw()
    {
    	background(0);
    	
    	int x = 20;
    	
    	for( Knoten kn : g.listKnoten() )
    	{
            if( kn != null)
            {
            	fill(100);
            	ellipse(x, 100, 20, 20);
            	fill(200);
            	text( kn.getElement().toString(), x, 100);
			}
			
			x += 40;
		}
    }
}
