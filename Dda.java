

package mypack;

import java.applet.Applet;
import java.awt.Graphics;


public class Dda extends Applet {

    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param g
     */
    public static void drawLine(double x1,double y1 ,double x2,double y2,Graphics g){
        double dx,dy,steps,xc,yc,x,y;
        dx = x2-x1;
        dy = y2-y1;
        if(Math.abs(dx) > Math.abs(dy))
               steps = Math.abs(dx) ;
       else
               steps = Math.abs(dy);
        xc = dx/steps;
        yc = dy/steps ;
        x=x1;
        y=y1;
        for(int k=1 ; k<=steps ; k++){
            x = x+xc ;
            y = y+yc ;
            g.fillOval((int)x, (int) y, 5, 5);
        }
    }
    
    public void paint(Graphics g){
        drawLine(10,10,30,100,g);
    }
    
}
