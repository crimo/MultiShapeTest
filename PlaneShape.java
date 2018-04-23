/**
 * @author      Chris Moore <cmoore12@radford.edu>
 * @version     1.0                                   
 * @since       2012-10-04         
 */

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A plane that can be moved around.
*/
public class PlaneShape implements MoveableShape
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
      Constructs a car item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public PlaneShape(int x, int y, int width)
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
    * Moves a PlaneShape
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
    	  y =height*-1-10;
    	//  System.out.println("low\nx: " + x + " y: "+ y);
      }
      
      else if (y <height*-1 -10 ){
    	  y = ICON_HEIGHT+40;
    	  //System.out.println("high\nx: " + x + " y: "+ y);
      }
   }
   
   /** Draws the shape
    * 
    * (non-Javadoc)
    * @see MoveableShape#draw(java.awt.Graphics2D)
    */
   public void draw(Graphics2D g2)
   {
	   
      Ellipse2D.Double body = new Ellipse2D.Double(x, y, width, height/2);
      Ellipse2D.Double wing = new Ellipse2D.Double(x+width/2, y-height+15, width/3, height*2);

      g2.setPaint(Color.DARK_GRAY);
      g2.fill(wing);
      g2.setPaint(Color.CYAN);
      g2.fill(body);
      

   }
   

}
