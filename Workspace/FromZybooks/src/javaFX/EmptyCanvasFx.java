package javaFX;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
/**
 * 
 * @author Zybooks author
 * 
 * */
public class EmptyCanvasFx extends Application {
   @Override
   public void start(Stage applicationStage) {
      Pane pane = new Pane();                    // Create an empty pane    
      Scene scene = new Scene(pane);             // Create a scene containing the pane
      Canvas canvas = new Canvas(400, 200);      // Create a canvas in which to draw
      
      // Get the canvas' graphics context to draw
      GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
      
      // Write your drawing instructions here
      
      pane.getChildren().add(canvas);            // Add canvas to pane 
      applicationStage.setTitle("Empty canvas"); // Set window's title
      applicationStage.setScene(scene);          // Set window's scene
      applicationStage.show();                   // Display window
   }
   
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}


