
import java.awt.*;
import java.awt.event.*;

public class GraphTest extends Frame
{
    private Closer handler;
    private Graph graph;
    
    public GraphTest( Graph gra)
    {
        this.graph = gra;
        
        handler = new Closer();
        setTitle("Frame Title");
        setSize(640, 480);
        addWindowListener(handler);
        show();
    }
    
    public void paint( Graphics g)
    {
        super.paint(g);
        
        Color grey = new Color(0.8f, 0.8f, 0.8f);
        Color black = new Color(0f, 0f, 0f);
        
        Util.LinkedListSingleChained<Integer[]> posTable = 
            new Util.LinkedListSingleChained<Integer[]>();
                
        int x = 50;
        int y = 50;
        int dia = 30;
        
        for( Knoten kn : graph.listKnoten() )
        {
            if( kn == null) break;
            else
               posTable.append( new Integer[] {x,y} );
            
            y += 200;
            if(y > 400) {
                x += 200;
                y = 50;
            }
        }
            
        for( Integer[] kante : graph.listKanten() )
        {
           Integer[] pos1 = posTable.getElement( kante[0] );
           Integer[] pos2 = posTable.getElement( kante[1] );

           g.drawLine(pos1[0]+dia/2, pos1[1]+dia/2, pos2[0]+dia/2, pos2[1]+dia/2);
        }
        
        int i = 0;
        for( Integer[] pos : posTable)
        {
           x = pos[0];
           y = pos[1];
           
           g.setColor(grey);
           g.fillOval(x, y, dia, dia);
           g.setColor(black);
           g.drawOval(x, y, dia, dia);
           g.drawString( graph.listKnoten()[i++].getElement().toString(), x+dia/2, y+dia/2);
        }
        
        
    }


    public static void main(String[] args) {
//         PApplet.main(new String[] { "MyProcessingSketch" });

        Frame app;
        
        Graph g = new GraphAdjList();        

        g.einfKnoten( new Knoten<Character>('a') );
        g.einfKnoten( new Knoten<Character>('b') );
        g.einfKnoten( new Knoten<Character>('c') );
        g.einfKnoten( new Knoten<Character>('d') );
        g.einfKnoten( new Knoten<Character>('e') );
        
        g.einfKante(1,2); // b-c
        g.einfKante(3,4); // d-e
        g.einfKante(0,3); // a-d
        g.einfKante(3,2); // d-c
        
//         for( Knoten kn : g.listKnoten() )
//             if( kn != null) System.out.println(kn.getElement());
//             
//         System.out.println(g.getAdjUnvisitedVertex(0));
// 
        g.dfs();
//         
        
        app = new GraphTest(g);
    }
}

class Closer extends WindowAdapter 
{
    public void windowClosing (WindowEvent event) {
        System.exit (0);
    }
}