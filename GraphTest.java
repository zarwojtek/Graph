
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GraphTest extends Frame
{
    private Closer handler;
    private Graph graph;
    
    public GraphTest( Graph gra, String title)
    {
        this.graph = gra;
        
        handler = new Closer();
        setTitle(title);
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
            
            y += 150;
            if(y > 450) {
                x += 150;
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


    public static void main(String[] args) 
    {
        Graph g = new GraphAdjList();
        
        Frame app;
        
        BufferedReader in = null;
        
        try {
            in = new BufferedReader( new FileReader("Graph.txt") );
        } catch( FileNotFoundException e) {
            System.out.println("Graph.txt not found");
        }
        
        try { 
            int num = Integer.parseInt( in.readLine() );
            
            for( int i=0; i<num; i++)
                g.einfKnoten( new Knoten<Integer>(i+1) );
            
            while(true)
            {
                String str;
                str = in.readLine();
                             
                if( str==null || str.length()==0)
                    break;
                
                String[] pair = str.split("-");
                int v1 = Integer.parseInt(pair[0]);
                int v2 = Integer.parseInt(pair[1]);
                g.einfKante(v1-1, v2-1);
            }

        }
        catch (IOException ioe) {}
       
        app = new GraphTest( g, "example Graph" );
        new GraphTest( g.dfs(), "DFS Graph");
        new GraphTest( g.bfs(), "BFS Graph");
    }
}

class Closer extends WindowAdapter 
{
    public void windowClosing (WindowEvent event) {
        System.exit (0);
    }
}