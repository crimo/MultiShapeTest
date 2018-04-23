/**
 * @author      Chris Moore <cmoore12@radford.edu>
 * @version     1.0                                   
 * @since       2012-10-04         
 */

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A boat that can be moved around.
*/
public class BoatShape implements MoveableShape
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
	private final int height = 40;
	
	/**
	 * Width of icon
	 */
	private static final int ICON_WIDTH = 400;
	
	/**
	 * Height of icon
	 */
	private static final int ICON_HEIGHT = 100;
	
   /**
      Constructs a boat shape.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public BoatShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      
      /*
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
    * Moves a BoatShape
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
    	  y =height*-1;
    	  //System.out.println("low\nx: " + x + " y: "+ y);
      }
      
      else if (y <height*-1 -40){
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
	   //Main rectangle of boat
      Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 6);
      
      //Bottom of mast
      Point2D.Double r1 = new Point2D.Double(x + width / 2, y-40);
      //Top of mast
      Point2D.Double r2 = new Point2D.Double(x + width / 2, y+15);
      //Point of flag
      Point2D.Double r3 = new Point2D.Double(x + width / 4, y-15);
      
      Line2D.Double mast = new Line2D.Double(r1, r2);
      Line2D.Double topSail = new Line2D.Double(r1, r3);
      Line2D.Double bottomSail = new Line2D.Double(r2, r3);
      
      g2.setPaint(Color.blue);
      g2.fill(body);
      g2.setPaint(Color.black);
      g2.draw(mast);
      g2.draw(topSail);
      g2.draw(bottomSail);
   }
   
}
