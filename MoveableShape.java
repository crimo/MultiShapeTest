/**
 * @author      Chris Moore <cmoore12@radford.edu>
 * @version     1.0                                   
 * @since       2012-10-04         
 */
import java.awt.*;

/**
   A shape that can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   
   /**
   	Translates all shapes in an icon
   */
   void translate();
}
