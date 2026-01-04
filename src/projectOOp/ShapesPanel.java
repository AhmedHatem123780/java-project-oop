package projectOOp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class ShapesPanel extends JPanel {

    Drawable[] arr;

    public ShapesPanel(Drawable[] arr) {
        this.arr = arr;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        g2.setPaint(new GradientPaint(0,0, new Color(135,206,250), w,h,new Color(25,25,112)));
        g2.fillRect(0,0,w,h);
        g2.setStroke(new BasicStroke(4));

        g2.setFont(new Font("Arial", Font.BOLD, 13));

        int x = 50;
        int y = 120;   

        for(int i=0;i<arr.length;i++) {

            if(arr[i] instanceof Circle){

                Circle c = (Circle)arr[i];
                double r = c.getRaduis();

                g2.setColor(Color.darkGray);
                g2.drawOval(x, y, (int)r, (int)r);

                g2.setColor(Color.white);  
                g2.drawString("Circle", x, y + (int)r + 20);
                g2.drawString("radius = " + r, x, y + (int)r + 40);

                x += (int)r + 120; 
            }

            else if(arr[i] instanceof Cube){

                Cube cu = (Cube)arr[i];
                double s = cu.getSide();
                int offset = (int)(s/3);

                g2.setColor(Color.darkGray);
                g2.drawRect(x,y,(int)s,(int)s);
                g2.drawRect(x+offset,y-offset,(int)s,(int)s);

                g2.drawLine(x,y,x+offset,y-offset);
                g2.drawLine(x+(int)s,y, x+(int)s+offset,y-offset);
                g2.drawLine(x,y+(int)s, x+offset,y+(int)s-offset);
                g2.drawLine(x+(int)s, y+(int)s, x+(int)s+offset, y+(int)s-offset);

                g2.setColor(Color.white);
                g2.drawString("Cube", x, y + (int)s + 20);
                g2.drawString("side = " + s, x, y + (int)s + 40);

                x += (int)s + 120;
            }
        }
    }
}
