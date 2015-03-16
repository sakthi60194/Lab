

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class LiangBarsky extends Applet implements MouseListener, MouseMotionListener {

    final int xMax = 500, yMax = 500;
    private int firstX, firstY, lastX, lastY, pnts = 0;
    static float xLeft = -100, xRight = 300, yBottom = -100, yTop = 300; //dimensions of rectangle to clip against
    java.awt.Point P0 = null, P1 = null;
    float[] p = new float[4];
    float[] q = new float[4];
    float[] r = new float[4];
    float max, min, u1, u2;

    public LiangBarsky() {
    }

    @Override
    public void init() {
        resize(xMax, yMax);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect((int) xLeft, (int) yBottom, (int) (xRight - xLeft), (int) (yTop - yBottom));
       /* if (P0 != null) {
            g.setColor(Color.RED);
            g.drawLine((int) P0.x, (int) P0.y, (int) P1.x, (int) P1.y);
        }*/
        Liang(P0, P1, g);
    }

    public void Liang(java.awt.Point P0, java.awt.Point P1, Graphics g) {
        g.drawRect((int) xLeft, (int) yBottom, (int) (xRight - xLeft), (int) (yTop - yBottom));
        float dx = (float) (P1.x - P0.x);
        float dy = P1.y - P0.y;
        p[0] = -dx;
            p[1] = dx;
        p[2] = -dy;
        p[3] = dy;
        q[0] = P0.x - xLeft;
        q[1] = xRight - P0.x;
        q[2] = P0.y - yBottom;
        q[3] = yTop - P0.y;
        for (int i = 0; i < 4; i++) {
            if (p[i] == 0 && q[i] < 0) {
                System.out.println("Parallel lines");
                return;
            }
        }
        max = 0;
        min = 1;
        for (int i = 0; i < 4; i++) {
            r[i] = q[i] / p[i];
//            System.out.println("i: " + i + " p[i]: " + p[i] + " q[i]: " + q[i] + " r[i]: " + r[i]);
            if (p[i] < 0) {
                if (r[i] > max) {
                    max = r[i];
                }
            } else {
                if (r[i] < min) {
                    min = r[i];
                }
            }
        }
        u1 = max;
        u2 = min;
        //  System.out.println(u1);
        //System.out.println(u2);
        if (u1 > u2) {
            System.out.println("Line completely outside");
            return;
        }
        System.out.println("First " + P0.x + " " + P0.y + " " + P1.x + " " + P1.y);
        float x1, y1, x2, y2;
        x1 = P0.x + (u1 * dx);
        y1 = P0.y + (u1 * dy);
        x2 = P0.x + (u2 * dx);
        y2 = P0.y + (u2 * dy);
        P0.x = (int) x1;
        P0.y = (int) y1;
        P1.x = (int) x2;
        P1.y = (int) y2;
        System.out.println("Last " + P0.x + " " + P0.y + " " + P1.x + " " + P1.y);
        g.setColor(Color.BLUE);
        g.drawLine((int) P0.x, (int) P0.y, (int) P1.x, (int) P1.y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        P0 = evt.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        P0 = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        P1 = evt.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        P1 = evt.getPoint();
    }
}
