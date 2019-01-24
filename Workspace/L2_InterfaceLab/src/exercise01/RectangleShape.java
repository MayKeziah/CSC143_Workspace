package exercise01;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/************************************************************************
 * <p> Lab 02 Exercise 01
 * 	   This class defines the attributes of a Rectangle shape.
 ************************************************************************/
public class RectangleShape {

	private double    x,  y;
	private double    height, width;
	private Rectangle rectangle;
	private Text      text;
	public static final int  WIDTH  = GUIWindow.WIDTH;
	public static final int  HEIGHT = GUIWindow.HEIGHT;
	
	/**********************************************************
	 *   generates  and initializes the attributes of the 
	 *   rectangular shape.
	 * ********************************************************/
	public RectangleShape() {
		this(50, 50);
	}
	
	/**********************************************************
	 *   generates  and initializes the attributes of the 
	 *   rectangular shape.
	 * ********************************************************/
	public RectangleShape(double width, double height) {
		this.width  = width;
		this.height = height;
		x      		= 50;
		y      		= 50;
	}
	
	/**********************************************************
	 *   generates  and initializes the attributes of the 
	 *   rectangular shape.
	 * ********************************************************/
	public RectangleShape(double x, double y, double width, double height) {
		this.width  = width;
		this.height = height;
		this.x      = x;
		this.y      = y;
	}
	
	/********************************************
	 *   compares to Rectangle shapes.
	 *   @return comparison
	 * ******************************************/
	public int functionA(RectangleShape r) {
		
		if(pixelArea() > r.pixelArea()) {
			return 1;
		}else if ( pixelArea() < r.pixelArea() ){
			return -1;
		}
		return 0;
	}
	
	/********************************************
	 *   functionB rectangle on display pane.
	 * ******************************************/
	public void functionB(Pane pane) {
		rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(Color.RED);
		pane.getChildren().add(rectangle);
	}
	
	/********************************************
	 *   computes area in pixels x pixels.
	 *   @return area
	 * ******************************************/
	public double pixelArea() {
		return width * height;
	}
	
	/********************************************
	 *   computes perimeter in pixels.
	 *   @return perimeter
	 * ******************************************/
	public double pixelPerimeter() {
		return 2 * width + 2 * height;
	}
	
	/********************************************
	 *   move rectangle to location specified.
	 * ******************************************/
	public void functionC(double dx, double dy) {
		// adjust location
		x += dx;				   // x + dx
		y += dy;				   // y + dy
				
		rectangle.setX(x);
		rectangle.setY(y);
	}
	/********************************************
	 *   writes text on the display pane.
	 * ******************************************/
	public void functionD(Pane pane) {
		text      = new Text(x, y + 1.5 * height, 
				             "\n Rectangle Description: "  
				             + "\n pixel Area : " + pixelArea()
				             + "\n pixel Perimeter : " + pixelPerimeter()
				            );
		
		text.setFont(Font.font("Palantino", 
								FontWeight.BOLD, 
								FontPosture.REGULAR, 20) );
		text.setFill(Color.WHITE);
		pane.getChildren().add(text);
		
	}
	
}
