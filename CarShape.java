import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A car that can be moved around.
*/
public class CarShape implements MoveableShape
{
	private int dx;
	private int dy;	
	private int x;
	private int y;
	private int width;
	private final int height = 50;
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	
   /**
      Constructs a car item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public CarShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      
      Random generator = new Random();
      do{
      	
      	dx = generator.nextInt(3)-1;
      	dy = generator.nextInt(3)-1;
      	//if (dx ==0 && dy == 0)
      		//  dx = 1;
      }
      while(dx == 0 && dy == 0);
   }
   
/*
   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
      if (x > ICON_WIDTH){
    	  x =0;
      }
      if (y > ICON_WIDTH){
    	  y =0 - 5;
      }
   } */
   
   public void translate()
   {
      x += dx;
      y += dy;
      
      if (x-width > ICON_WIDTH){
    	  x =width*-1;
      System.out.println("right\nx: " + x + " y: "+ y);
      }
      
      else if (x < 0 - width){
    	  x = ICON_WIDTH+ width;
      System.out.println("left\nx: " + x + " y: "+ y);
      }
      
      if (y > ICON_HEIGHT){
    	  y =height*-1;
    	  System.out.println("low\nx: " + x + " y: "+ y);
      }
      
      else if (y <height*-1 ){
    	  y = ICON_HEIGHT;
    	  System.out.println("high\nx: " + x + " y: "+ y);
      }
   }

   public void draw(Graphics2D g2)
   {
      Rectangle2D.Double body
            = new Rectangle2D.Double(x, y + width / 6, 
                  width - 1, width / 6);
      Ellipse2D.Double frontTire
            = new Ellipse2D.Double(x + width / 6, y + width / 3, 
                  width / 6, width / 6);
      Ellipse2D.Double rearTire
            = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
                  width / 6, width / 6);

      // The bottom of the front windshield
      Point2D.Double r1
            = new Point2D.Double(x + width / 6, y + width / 6);
      // The front of the roof
      Point2D.Double r2
            = new Point2D.Double(x + width / 3, y);
      // The rear of the roof
      Point2D.Double r3
            = new Point2D.Double(x + width * 2 / 3, y);
      // The bottom of the rear wind shield
      Point2D.Double r4
            = new Point2D.Double(x + width * 5 / 6, y + width / 6);
      Line2D.Double frontWindshield
            = new Line2D.Double(r1, r2);
      Line2D.Double roofTop
            = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield
            = new Line2D.Double(r3, r4);
      
      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);
      g2.draw(roofTop);
      g2.draw(rearWindshield);
   }
   

}
