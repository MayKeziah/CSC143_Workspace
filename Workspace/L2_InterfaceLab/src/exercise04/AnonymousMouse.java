package exercise04;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/************************************************************************
 * <p>  Lab 02 Exercise 04
 * 	    This class is used to create graphical components on a
 *      graphical layout with features of a Pane layout. 
 * <br> A mouse event signal detector is created as an anonymous inner 
 *      class. 
 ************************************************************************/
public class AnonymousMouse extends Pane{
	
	/************************************
	 * data fields: encapsulation of data
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
	public AnonymousMouse() {
		
		height = 100;
		width  = 100;
		x      = (WIDTH  - width)/2;
		y      = (HEIGHT - height)/2;
		
		/********************************************************
		 * 	use an anonymous class to change the pane color
		 *  when mouse enters the GUI window.
		 * ******************************************************/
		setOnMouseEntered( new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event) {
				setStyle("-fx-background-color: lime green;");
				}
		} );
		
		/********************************************************
		 * 	use an anonymous class to change the pane color
		 *  when mouse leaves the GUI window.
		 * ******************************************************/
		setOnMouseExited( new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event) {
				setStyle("-fx-background-color: red;");
				}
		} );
		
		square = new Rectangle(x, y, width, height);
		square.setFill(Color.YELLOW);
		
		/**********************************************
		 * 	define what happens to the square shape 
		 *  once the mouse is moved.
		 * ********************************************/
		square.setOnMouseMoved( new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event) {
				move(event);
			}
		}  );
		
		getChildren().add(square);
	}
	
	/*******************************************************************
	 *   moves square when a mouse event is detected and add  a black 
	 *   outline to the square.
	 * *****************************************************************/
	public void move(MouseEvent event) {
		
		if (square.contains(event.getX(), event.getY())) {
			square.setX(event.getX() - width / 2);
			square.setY(event.getY() - height / 2);
			square.setStroke(Color.BLACK);
		}
	}
	
}
