package exercise01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/************************************************************************
 * <p> Lab 02 Exercise 01
 * 	   This class is a general window for displaying graphical
 *     components.This format can be used for all window displays.
 ************************************************************************/
public class GUIWindow extends Application {
	
	public static final int  WIDTH  = 500;
	public static final int  HEIGHT = 500;
	
	/*****************************************************************
	 *    overrides the start method in the Application class
	 * ***************************************************************/
	@Override
	public void start(Stage stage) {
		
		/*******************************************************************
		 * required:  Pane 
		 * 			  create a Display Pane to hold graphics drawings.  
		 * *****************************************************************/
		Pane pane  = new Pane();
		pane.setStyle("-fx-background-color: black;");
		
		//create a rectangle using Rectangle Shape
		RectangleShape rect1 = new RectangleShape(200, 100);
		RectangleShape rect2 = new RectangleShape(100, 200);
		rect1.functionB(pane);
		rect1.functionD(pane);
		rect2.functionB(pane);
		rect2.functionC(300, 0);
		
		/**********************************************************
		 * required:  Scene
		 * 			  create a scene object to hold the pane object
		 * 			  and place it in the stage for display
		 * ********************************************************/
		Scene scene = new Scene(pane, WIDTH, HEIGHT, Color.LIGHTGREY);   
		stage.setTitle("Display Window");			
		stage.setScene(scene);					
		stage.show();
	}
	
	/********************************************************************
	 *    needed to launch JavaFX program when running in IDE
	 * ******************************************************************/
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
