/**
 * @author      Chris Moore <cmoore12@radford.edu>
 * @version     1.0                                   
 * @since       2012-10-04         
 */

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A clock that can be moved around.
*/
public class ClockShape implements MoveableShape
{
	/**
	 * Horizontal movement direction
	 */
	private int dx;
	
	/**
	 * Vertical movement direction
	 */
	private int dy;	
	
	/**
	 * Horizontal position
	 */
	private int x;
	
	/**
	 * Vertical position
	 */
	private int y;
	
	/**
	 * Width of shape
	 */
	private int width;
	
	/**
	 * Height of shape
	 */
	private final int height = 50;
	
	/**
	 * Width of icon
	 */
	private static final int ICON_WIDTH = 400;
	
	/**
	 * Height of icon
	 */
	private static final int ICON_HEIGHT = 100;
	
   /**
      Constructs a Clock shape.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public ClockShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      
      /**
       * Random motion directions are generated
       * 
       * dx && dy cannot both be zero, or the shape would be standing still
       */
      Random generator = new Random();
      do{
      	dx = generator.nextInt(3)-1;
      	dy = generator.nextInt(3)-1;
      }
      while(dx == 0 && dy == 0);
   }
   
   /**
    * Moves a ClockShape
    * 
    * When shape reaches an edge, it will wrap around to the appropriate side.
    * 
    * (non-Javadoc)
    * @see MoveableShape#translate()
    */
   public void translate()
   {
      x += dx;
      y += dy;
      
      if (x-width > ICON_WIDTH){
    	  x =width*-1;
    	  //System.out.println("right\nx: " + x + " y: "+ y);
      }
      
      else if (x < 0 - width){
    	  x = ICON_WIDTH+ width;
    	  //System.out.println("left\nx: " + x + " y: "+ y);
      }
      
      if (y > ICON_HEIGHT+40){
    	  y =height*-1-40;
    	  //System.out.println("low\nx: " + x + " y: "+ y);
      }
      
      else if (y <height*-1 -50){
    	  y = ICON_HEIGHT+40;
    	  //System.out.println("high\nx: " + x + " y: "+ y);
      }
   }

   /**
    * Draws the shape
    * 
    * (non-Javadoc)
    * @see MoveableShape#draw(java.awt.Graphics2D)
    */
   public void draw(Graphics2D g2)
   {
	   //Main circle of clock
      Ellipse2D.Double circle= new Ellipse2D.Double(x , y , width , width);
     
      //Center of clock
      Point2D.Double r1 = new Point2D.Double(x+50,y+50);
      //Top of minute hand
      Point2D.Double r2 = new Point2D.Double(x+50,y+10);
      //Point of hour hand
      Point2D.Double r3 = new Point2D.Double(x+70,y+50);
      
      Line2D.Double minute = new Line2D.Double(r1, r2);
      Line2D.Double hour = new Line2D.Double(r1, r3);
      
 
      g2.setPaint(Color.GRAY);
      g2.fill(circle);
      g2.setPaint(Color.black);
      g2.draw(minute);
      g2.draw(hour);
    
   }
   

}
