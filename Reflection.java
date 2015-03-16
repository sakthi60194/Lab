
package mypack;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static mypack.Dda.drawLine;



public class Reflection extends Applet implements MouseListener{
   static int flag=400;
    /**
     *
     * @param a
     * @param first
     */
    public static void mult_matrix(int[][]first,int[][]second,int[][]multiply,int m,int n,int p,int q)
    {  
      int  sum = 0, c, d, k,i,j;
 /*
  for(i=0 ; i<m ; i++){
           for(j=0 ; j<n ; j++)
              System.out.print(first[i][j] + " ");
           System.out.println();
       }
 
  
  for(i=0 ; i<p ; i++){
           for(j=0 ; j<q ; j++)
              System.out.print(second[i][j] + " ");
           System.out.println();
       }
 */
         for ( c = 0 ; c < m ; c++ )
         {
            for ( d = 0 ; d < q ; d++ )
            {  
                
               for ( k = 0 ; k < p ; k++ )
               {
                  
                  sum = sum + first[c][k]*second[k][d];
               }
              
               multiply[c][d] = sum;
               sum = 0;
            }
         }
 
        /*
 
         for ( c = 0 ; c < m ; c++ )
         {
            for ( d = 0 ; d < q ; d++ )
               System.out.print(multiply[c][d]+"\t");
 
            System.out.print("\n");
         }*/
      }
    public static void plot(Graphics g){
         double x1 = flag,y1=0,x2=flag,y2 = flag+flag ;
            drawLine(x1,y1,x2,y2,g);
            x1 = 0;y1=flag;x2=flag+flag;y2=flag;
            drawLine(x1,y1,x2,y2,g);
    }
    public static void drawTriangle(double x1,double y1,double x2,double y2,double x3,double y3,Graphics g){
        drawLine(x1,y1,x2,y2,g);
        drawLine(x2,y2,x3,y3,g);
        drawLine(x3,y3,x1,y1,g);
    }
    
    public static void genMatrix(double x1,double y1,int[][]m){
        m[0][0] = (int)x1;
        m[1][0] = (int)y1 ;
        m[2][0] = 1;
    }
    public static void reflect_Origin(double x1,double y1,double x2,double y2,double x3,double y3,Graphics g){
        int[][] mat = new int[3][1];
        int[][] ref = new int[3][3];
       int[][] p = new int[3][1];
       int i,j;
       for(i=0 ; i<3 ; i++){
           for(j=0 ; j<3 ; j++)
               
               ref[i][j] = 0;
       }
       ref[0][0] = -1;
       ref[1][1] = -1;
       ref[2][2] = 1;
       genMatrix(x1,y1,p);
       mult_matrix(ref,p,mat,3,3,3,1);
       double PX_1,PX_2,PX_3,PY_1,PY_2,PY_3 ;
       PX_1 = mat[0][0] ;
       PY_1 = mat[1][0];
       genMatrix(x2,y2,p);
       mult_matrix(ref,p,mat,3,3,3,1);
       PX_2 = mat[0][0] ;
       PY_2 = mat[1][0];
       genMatrix(x3,y3,p);
       mult_matrix(ref,p,mat,3,3,3,1);
        PX_3 = mat[0][0] ;
       PY_3 = mat[1][0];
         drawTriangle(PX_1+flag,flag-PY_1,PX_2+flag,flag-PY_2,PX_3+flag,flag-PY_3,g);
       
       
    }   
    
      public static void reflect_Xaxis(double x1,double y1,double x2,double y2,double x3,double y3,Graphics g){
        int[][] mat = new int[3][1];
        int[][] ref = new int[3][3];
       int[][] p = new int[3][1];
       int i,j;
       for(i=0 ; i<3 ; i++){
           for(j=0 ; j<3 ; j++)
               
               ref[i][j] = 0;
       }
       ref[0][0] = 1;
       ref[1][1] = -1;
       ref[2][2] = 1;
       genMatrix(x1,y1,p);
       mult_matrix(ref,p,mat,3,3,3,1);
       double PX_1,PX_2,PX_3,PY_1,PY_2,PY_3 ;
       PX_1 = mat[0][0] ;
       PY_1 = mat[1][0];
       genMatrix(x2,y2,p);
       mult_matrix(ref,p,mat,3,3,3,1);
       PX_2 = mat[0][0] ;
       PY_2 = mat[1][0];
       genMatrix(x3,y3,p);
       mult_matrix(ref,p,mat,3,3,3,1);
        PX_3 = mat[0][0] ;
       PY_3 = mat[1][0];
         drawTriangle(PX_1+flag,flag-PY_1,PX_2+flag,flag-PY_2,PX_3+flag,flag-PY_3,g);
       
       
    }   
      
        public static void reflect_Yaxis(double x1,double y1,double x2,double y2,double x3,double y3,Graphics g){
        int[][] mat = new int[3][1];
        int[][] ref = new int[3][3];
       int[][] p = new int[3][1];
       int i,j;
       for(i=0 ; i<3 ; i++){
           for(j=0 ; j<3 ; j++)
               
               ref[i][j] = 0;
       }
       ref[0][0] = -1;
       ref[1][1] = 1;
       ref[2][2] = 1;
       genMatrix(x1,y1,p);
       mult_matrix(ref,p,mat,3,3,3,1);
       double PX_1,PX_2,PX_3,PY_1,PY_2,PY_3 ;
       PX_1 = mat[0][0] ;
       PY_1 = mat[1][0];
       genMatrix(x2,y2,p);
       mult_matrix(ref,p,mat,3,3,3,1);
       PX_2 = mat[0][0] ;
       PY_2 = mat[1][0];
       genMatrix(x3,y3,p);
       mult_matrix(ref,p,mat,3,3,3,1);
        PX_3 = mat[0][0] ;
       PY_3 = mat[1][0];
         drawTriangle(PX_1+flag,flag-PY_1,PX_2+flag,flag-PY_2,PX_3+flag,flag-PY_3,g);
       
       
    }   
        public void paint(Graphics g){
            plot(g);
           double p1_x = 10,p1_y=10 ,p2_x = 30,p2_y = 30 ,p3_x = 50,p3_y=10;
            drawTriangle(p1_x+flag,flag-p1_y,p2_x+flag,flag-p2_y,p3_x+flag,flag-p3_y,g);
           
            //reflection about origin
             g.setColor(Color.red);
            reflect_Origin(p1_x,p1_y,p2_x,p2_y,p3_x,p3_y,g);
            g.setColor(Color.BLUE);
              reflect_Xaxis(p1_x,p1_y,p2_x,p2_y,p3_x,p3_y,g);
             g.setColor(Color.GREEN);
              reflect_Yaxis(p1_x,p1_y,p2_x,p2_y,p3_x,p3_y,g);
             // g.drawString("Reflect origin: red color",10,10);
            
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //=e.getY();
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ///throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   }
    

