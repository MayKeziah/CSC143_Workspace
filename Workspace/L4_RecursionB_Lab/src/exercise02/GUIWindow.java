/************************************************************************
 * <p>This class is a general window for displaying graphical
 *    components.This format can be used for all window displays.
 ************************************************************************/
package exercise02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIWindow extends Application {
	
	public static final int  WIDTH  = 500;
	public static final int  HEIGHT = 520;
	
	/*****************************************************************
	 * override: start
	 *           overrides the start method in the Application class
	 * ***************************************************************/
	@Override
	public void start(Stage stage) {
		
		/*******************************************************************
		 * required:  Pane 
		 * 			  create a Pane to hold graphics.  
		 * *****************************************************************/
		Controller pane  = new Controller();
		pane.setStyle("-fx-background-color: white;");
		
		/**********************************************************
		 * required:  Scene
		 * 			  create a scene object to hold the pane object
		 * 			  and place it in the stage for display
		 * ********************************************************/
		Scene scene = new Scene(pane, WIDTH, HEIGHT, Color.WHITE);   
		stage.setTitle("Sierpinski Triangle");			
		stage.setScene(scene);					
		stage.show();
		
	}
	
	/********************************************************************
	 * main method: launch application
	 *              needed to launch JavaFX program when running in IDE
	 * ******************************************************************/
	public static void main(String[] args) {
		launch(args);
	}
	
}
