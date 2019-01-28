package exercise04;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**************************************************************************
 * <p>  Lab 02 Exercise 04
 * 		This class is used to create graphical components on a
 *      graphical layout with features of a Pane layout. 
 * <br> A key event signal detector is created as an anonymous inner 
 *      class. 
 **************************************************************************/
public class AnonymousKey extends Pane{
	
	/************************************
	 * data fields: encapsulation of data
	 * **********************************/
	private double    x,  y;
	private double    height, width;
	private Rectangle square;
	
	public static final int  WIDTH  = WindowB.WIDTH;
	public static final int  HEIGHT = WindowB.HEIGHT;
    	
	/**********************************************************************
	 *   creates a drawing panel object that will be placed in a Scene 
	 *   object that is contained in a Stage object. 
	 * ********************************************************************/
	public AnonymousKey() {
		
		height = 100;
		width  = 100;
		x      = (WIDTH  - width)/2;
		y      = (HEIGHT - height)/2;
		

		square = new Rectangle(x, y, width, height);
		square.setFill(Color.YELLOW);
		
		/**********************************************
		 * 	define what happens to the square once the
		 *  arrows keys are pressed.
		 * ********************************************/
		square.setOnKeyPressed( new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				 move(event);
			}
		} );
		
		/**********************************************
		 * 	focus key strokes on Rectangle shape.
		 * ********************************************/
		square.setFocusTraversable(true);
		getChildren().add(square);
	}
	
	/*******************************************************************
	 *    moves square with detection of key events
	 * *****************************************************************/
	public void move(KeyEvent event) {
		setStyle("-fx-background-color: grey;");
		if (event.getCode() == KeyCode.UP) {
			square.setY(square.getY() - 15 );
		}else if (event.getCode() == KeyCode.DOWN) {
			square.setY(square.getY() + 15 );
		}else if (event.getCode() == KeyCode.LEFT) {
			square.setX(square.getX() - 15 );
		}else if (event.getCode() == KeyCode.RIGHT) {
			square.setX(square.getX() + 15 );
		}
	}
	
}
