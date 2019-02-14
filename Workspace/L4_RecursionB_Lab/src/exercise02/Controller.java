package exercise02;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/************************************************************************
 * <p> Lab 04 Exercise 02
 * 	   This is a Pane for holding the label, text field, and button for
 * 	   display.
 ************************************************************************/
public class Controller extends BorderPane {

	private Button				btnDown;
	private Button				btnUp;
	private HBox 	   			hBox;
	private Label 				lbHBox;
	private Label 				lbLevel;
	private LinedSierpinski 	trianglePane;
	
	/**********************************************************
	 *  constructor that generates and initializes the 
	 *  attributes of Controller. 
	 * ********************************************************/
	public Controller() {
		
		trianglePane	= new LinedSierpinski();
		btnDown 		= new Button("-");
		btnUp 			= new Button("+");
		lbHBox			= new Label();
		lbLevel			= new Label("Level: " + trianglePane.getLevel());
		hBox	 		= new HBox(25);

		// listener for when buttons pressed in pane.
		btnDown.setOnAction(e -> levelDown());
		btnUp.setOnAction(e -> levelUp());
		
		//label header for horizontal box 
		lbHBox.setGraphic(new Label(" Level "));
		lbHBox.getGraphic().setStyle("-fx-background-color: white;");
		lbHBox.setPadding(new Insets(-40, 225, 0, 0));
		
		//horizontal box with header label
		hBox.setPadding(new Insets(5, 20, 5, 0));
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(lbHBox, btnUp, btnDown, lbLevel);
		
		/********************************************************
		 * draw border: HBox
		 * 		        draw black border around horizontal box.
		 * ******************************************************/
		hBox.setStyle("-fx-background-color: white;");
		hBox.setStyle("-fx-border-style: solid inside;");
		hBox.setStyle("-fx-border-width:  1;");
		hBox.setStyle("-fx-border-insets: 1;");
		hBox.setStyle("-fx-border-color: black;");
		
		//top right bottom left padding of triangle pane
		trianglePane.setPadding(new Insets(0,0,10,0));
		
		//listener for resizing triangle pane
		trianglePane.widthProperty().addListener(x -> trianglePane.draw());
		trianglePane.heightProperty().addListener(y -> trianglePane.draw());
		
		//top right bottom left padding of pane
		setPadding(new Insets(5,10,10,10));
		
		//listener for keys pressed on pane
		setOnKeyPressed(e-> keyControl(e));
		
		//organize other panes on border pane layout
		setCenter(trianglePane);
		setBottom(hBox);
		
	}
	
	/**********************************************************
	 *  changes current level and displays current level using
	 *  up/down arrow keys.
	 * ********************************************************/
	public void keyControl(KeyEvent event) {
		if(event.getCode() == KeyCode.UP) {
			levelUp();
		}else if(event.getCode() == KeyCode.DOWN) {
			levelDown();
		}
	}
	
	/**********************************************************
	 *  decreases current level and displays current level.
	 * ********************************************************/
	public void levelDown() {
		if (trianglePane.getLevel() != 1) {
			trianglePane.setLevel(trianglePane.getLevel() - 1);
			lbLevel.setText("Level: " + trianglePane.getLevel());
		}
	}
	
	/**********************************************************
	 *  increases current level and displays current level.
	 * ********************************************************/
	public void levelUp() {
		trianglePane.setLevel(trianglePane.getLevel() + 1);
		lbLevel.setText("Level: " + trianglePane.getLevel());
	}
}
