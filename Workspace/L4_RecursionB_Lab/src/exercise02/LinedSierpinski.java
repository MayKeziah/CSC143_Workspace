package exercise02;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/************************************************************************
 * <p> Lab 04 Exercise 02
 * 	   This is a pane for displaying different levels of a Sierpinski
 * 	   Triangle constructed with line segments.
 ************************************************************************/
public class LinedSierpinski extends Pane{

	/********************************************************
	 *   data field: keeps the value of the current level
	 *               of the Sierpinski Triangle.
	 * *****************************************************/
	private int level;
	
	/**********************************************************
	 *  constructor that generates and initializes the 
	 *  attributes of the Sierpinski Triangle.
	 * ********************************************************/
	public LinedSierpinski() {
		level 	= 	1;
	}
	
	/**********************************************************
	 *  validates the level of the Sierpinski Triangle and 
	 *  returns a valid level.
	 * ********************************************************/
	public int checkLevel(int level) {
		if (level < 1) {
			return 1;
		}else {
			return level;
		}
	}
	
	/**********************************************************
	 *  selects three points for the vertices of level 1 of the
	 *  Sierpinski Triangle in proportion to the pane size.
	 * ********************************************************/
	public void draw() {
		//create 3 points for triangle vertices
		Point2D p1 = new Point2D(getWidth() / 2, 10);
		Point2D p2 = new Point2D(10, getHeight() - 10);
		Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
		
		//clear the pane before redrawing figure.
		getChildren().clear();
		
		//draw figure
		drawFigure(level, p1, p2, p3);
	}
	
	/**********************************************************
	 *  draws the levels of a Sierpinski Triangle.
	 * ********************************************************/
	public void drawFigure(int level, Point2D p1, Point2D p2 , Point2D p3) {
		
		level = checkLevel(level);
		
		/*****************************************************
		 * end case: level 1
		 * 			 draw a triangle to connect three points.
		 * ***************************************************/
		if(level == 1) {
			
			//create triangle object
			Polygon triangle = new Polygon();
			
			//set the vertices at the points specified
			triangle.getPoints()
					.addAll(p1.getX(), p1.getY(), 
							p2.getX(), p2.getY(),
							p3.getX(), p3.getY());
			
			//outline triangle, inside fill is WHITE
			triangle.setStroke(Color.BLACK);
			triangle.setFill(Color.WHITE);
			
			//place triangle drawing on pane
			getChildren().add(triangle);
			
		}else {
			
			/***********************************************************
			 * recursive case: finding midpoints
			 * 			 	   split into three triangles
			 * *********************************************************/
			Point2D p4  = p1.midpoint(p2);
			Point2D p5  = p2.midpoint(p3);
			Point2D p6  = p1.midpoint(p3);
			
			/**********************************************************
			 * recursive case: reduce level
			 * 			 	   reduction level on triangle areas.
			 * ********************************************************/
			drawFigure(level - 1, p1, p4, p6);		// lower left sub-triangle
			drawFigure(level - 1, p4, p2, p5);		// top  sub-triangle
			drawFigure(level - 1, p6, p5, p3);		// lower right sub-triangle
		}
	}
	
	/**********************************************************
	 *  returns the level of the Sierpinski Triangle.
	 * ********************************************************/
	public int getLevel() {
		return checkLevel(level);
	}
	
	/**********************************************************
	 *  sets the level of the Sierpinski Triangle then draws
	 *  the triangle.
	 * ********************************************************/
	public void setLevel(int level) {
		this.level = checkLevel(level);
		draw();
	}
}
