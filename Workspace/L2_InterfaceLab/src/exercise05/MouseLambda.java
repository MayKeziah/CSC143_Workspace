package exercise05;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**********************************************************************
 * <p> Lab 02 Exercise 05
 *     This class is used to create graphical components on a
 *     graphical layout with features of a Pane layout. 
 * <br>A  mouse event signal detector is created as lambda expression.
 **********************************************************************/
public class MouseLambda extends Pane{
	
	/************************************
	 * State: data fields
	 *        encapsulation of data
	 * **********************************/
	private double    x,  y;
	private double    height, width;
	private Rectangle square;
	public static final int  WIDTH  = WindowA.WIDTH;
	public static final int  HEIGHT = WindowA.HEIGHT;
    	
	/**********************************************************************
	 *   creates a drawing panel object that will be placed in a Scene 
	 *   object that is contained in a Stage object. 
	 * ********************************************************************/
	public MouseLambda() {
		height = 100;
		width  = 100;
		x      = (WIDTH  - width) / 2;
		y      = (HEIGHT - height) / 2;
		
		/****************************************************************
		 *  use a lambda expression to change the pane color
		 *  when mouse enters/leaves the GUI window.
		 * **************************************************************/
		// (1) write the lambda expression for setOnMouseEntered to CYAN.
		
		// (2) write the lambda expression for setOnMouseEXITED to YELLOW.
		
		square = new Rectangle(x, y, width, height);
		square.setFill(Color.BLUEVIOLET);
		
		/*****************************************************************
		 *  use a lambda expression to move the square shape.
		 * ***************************************************************/
		// (3) write the lambda expression for setOnMouseMoved to move.
		
		getChildren().add(square);
	}
	
	/*******************************************************************
	 * method: move(MouseEvent)
	 *         move square with detection of mouse events and add black 
	 *         outline.
	 * *****************************************************************/
	public void move(MouseEvent event) {
		
		if (square.contains(event.getX(), event.getY())) {
			square.setX(event.getX() - width / 2);
			square.setY(event.getY() - height / 2);
			square.setStroke(Color.BLACK);
		}
	}
	
}
