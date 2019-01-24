package exercise03;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/************************************************************************
 * <p>  Lab 02 Exercise 03
 * 	    This class is used to create graphical components on a
 *      graphical layout with features of a Pane layout. 
 ************************************************************************/
public class InnerPane extends Pane{
	
	/************************************
	 * data fields: encapsulation of data
	 * **********************************/
	private double    x,  y;
	private double    height, width;
	private Rectangle square;
    	
	public static final int  WIDTH  = GUIWindow.WIDTH;
	public static final int  HEIGHT = GUIWindow.HEIGHT;
	
	/**********************************************************************
	 *   creates a drawing panel object that will be placed in a Scene 
	 *   object that is contained in a Stage object. 
	 * ********************************************************************/
	public InnerPane() {
		
		height = 100;
		width  = 100;
		x      = (WIDTH  - width)/2;
		y      = (HEIGHT - height)/2;
		
		// create an inner class object
		Inner detector = new Inner();
		
		//create a square graphics object
		square = new Rectangle(x, y, width, height);
		square.setFill(Color.CYAN);
		
		//invoke the registration methods and specify the detector
		square.setOnMouseMoved(detector);
		
		//add square to current InnerPane drawing area
		getChildren().add(square);
	}
	
	/*******************************************************************
	 *   move square with detection of mouse events and add black 
	 *   outline.
	 * *****************************************************************/
	public void move(MouseEvent event) {
		setStyle("-fx-background-color: grey;");
		if (square.contains( event.getX(), event.getY() ) ) {
			square.setX(event.getX() - width / 2);
			square.setY(event.getY() - height / 2);
			square.setStroke(Color.BLACK);
		}
	}

	/*******************************************************************
	 *<p> This is an example of an inner class. It is used to handle the
	 *    mouse signals that are detected by the system.
	 * *****************************************************************/
	private class Inner implements EventHandler<MouseEvent>{
		
		/*******************************************************************
		 *   sets the behavior of the display window once the mouse signals 
		 *   have been detected.
		 * *****************************************************************/
		public void handle(MouseEvent event) {
			//place implementation here (response to mouse movements)
		}
	}
	
}
