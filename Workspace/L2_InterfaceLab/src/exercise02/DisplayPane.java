package exercise02;

import exercise01.Drawable;
import exercise01.Moveable;
import exercise01.Writeable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/************************************************************************
 * <p>  Lab 02 Exercise 02
 * 	    This class is used to create graphical components on a
 *      graphical layout with features of a Pane layout. 
 ************************************************************************/
public class DisplayPane extends Pane implements Drawable, Moveable, Writeable {
	
	/************************************
	 * data fields: encapsulation of data
	 * **********************************/
	private double    x,  y;
	private double    height, width;
	private Rectangle rectangle;
	private Text      text;
    	
	public static final int  WIDTH  = WindowA.WIDTH;
	public static final int  HEIGHT = WindowA.HEIGHT;
	
	/**********************************************************************
	 *   creates a drawing panel object that will be placed in a Scene 
	 *   object that is contained in a Stage object. 
	 * ********************************************************************/
	public DisplayPane() {
		
		height = 100;
		width  = 100;
		x      = (WIDTH  - width)/2;
		y      = (HEIGHT - height)/2;
		
	}
	
	/********************************************
	 *   draw rectangle on display pane.
	 * ******************************************/
	public void draw(Pane pane) {
		rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(Color.YELLOW);
		pane.getChildren().add(rectangle);
	}
	
	/********************************************
	 *   move rectangle to location specified.
	 * ******************************************/
	public void move(double dx, double dy) {
		// adjust location
		x += dx;				   // x + dx
		y += dy;				   // y + dy
				
		rectangle.setX(x);
		rectangle.setY(y);
	}
	
	/********************************************
	 *   writes text on the display pane.
	 * ******************************************/
	public void write(Pane pane) {
		text  = new Text(x, y + 1.5 * height, 
				         "\n Rectangle Description: "  
				         + "\n pixel Area : " 
				         + rectangle.getWidth() * rectangle.getHeight()
				         + "\n pixel Perimeter : " 
				         + 2 * rectangle.getWidth() + 2 * rectangle.getHeight()
				         );
		
		text.setFont(Font.font("Palantino", 
								FontWeight.BOLD, 
								FontPosture.REGULAR, 20) );
		text.setFill(Color.WHITE);
		pane.getChildren().add(text);
		
	}

}
