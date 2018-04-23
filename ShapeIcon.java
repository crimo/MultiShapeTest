/**
 * @author      Chris Moore <cmoore12@radford.edu>
 * @version     1.0                                   
 * @since       2012-10-04         
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   An icon that can contain multiple movable shapes
*/
public class ShapeIcon implements Icon
{
		/*
		* Width of the icon
		*/
	   private int width;
	   /*
	    * Height of the icon
	    */
	   private int height; 
	   /*
	    * Holds all movable shapes to be displayed in icon
	    */
	   private ArrayList<MoveableShape> shapes;
	   
	   
	   /**
	    * Creates a ShapeIcon
	    * 
	    * @param width 	Created width of icon
	    * @param height Created height of icon
	    */
	public ShapeIcon(int width, int height)
   { 
	  shapes = new ArrayList<MoveableShape>();	
	  this.width = width;
      this.height = height;
   }
   
   public int getIconWidth()
   {
      return width;
   }

   public int getIconHeight()
   {
      return height;
   }

   /*
    * Adds a movable shape to the array list
    */
   public void add(MoveableShape shapeToAdd){
	   shapes.add(shapeToAdd);
   }
   
   /*
    * Cycles through shapes array list of shapes and moves each one
    */
   public void translateAll(){
	   for (MoveableShape shapeToTranslate : shapes){
	      shapeToTranslate.translate(); 
	   }
	   
   }
   
   /* Paints the icon with all current shapes displayed
    * 
    * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
    */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (MoveableShape shapeToDraw : shapes){
      	shapeToDraw.draw(g2);
      }
   }
   
   /*
    * Removes all current shapes from icon
    */
   public void clearAll(){
	   shapes.clear();
   }

   /*
    * Removes the last shape added to the array list
    */
   public void remove(){
	   if(shapes.size()>0)
	   	shapes.remove(shapes.size()-1);
   }

}


