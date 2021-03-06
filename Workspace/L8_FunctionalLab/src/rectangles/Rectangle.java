package rectangles;

import group.Comparable;

/**************************************************************
 * <p>This class describes the attributes of rectangle objects
 **************************************************************/
public class Rectangle implements Comparable<Rectangle>{
	
	/*****************************************
	 *  data fields (state) of the object.
	 * ***************************************/
	private int height;
	private int width;
	
	/*********************************************
	 *  default values initialize state.
	 *********************************************/
	public Rectangle() {
		this(100, 100);
	}
	
	/********************************************
	 *   passed values initialize state.
	 * ******************************************/
	public Rectangle(int width, int height) {
		this.height = height;
		this.width  = width;
	}
	
	/************************************************
	 *   computes the area of the current rectangle
	 *   object requested.
	 *   @return area of rectangle
	 * **********************************************/
	public int area() {
		return width * height;
	}
	
	/******************************************************
	 *  compares the dimensions of two rectangle objects.
	 *  The height is used to break ties.
	 *  @return result of comparison.
	 * ****************************************************/
	public static int compareDimensions(Rectangle r1, Rectangle r2) {
		//update
		if  (r1.getWidth() == r2.getWidth()) {
			return r1.getHeight() - r2.getHeight();
		} 	return r1.getWidth()  - r2.getWidth();
	}
	
	/******************************************************
	 *  compares the perimeters of two rectangle objects.
	 *  @return result of comparison.
	 * ****************************************************/
	public static int comparePerimeters(Rectangle r1, Rectangle r2) {
		//update
		return r1.perimeter() - r2.perimeter();
	}
	
	/*********************************************************
	 *  defines the "natural" ordering rules for this object.
	 * *******************************************************/
	public int compareTo(Rectangle other) {
		//update
		return area() - other.area();
	}
	
	/******************************************************************
	 * 	indicates whether the "state" of the current object has the 
	 *  same "state" (contents) as the passed object.
	 * 	@param other object to compare.
	 *  @return boolean if equals is true or false.
	 ******************************************************************/
	public boolean equals(Object other) {
		// update
		if (other instanceof Rectangle) {
			return (  
					(  (Rectangle) other  ).getWidth()  == getWidth() 
				 && (  (Rectangle) other  ).getHeight() == getHeight()  
				   );
		}
		return false;
	}
	
	/*********************************************************
	 *  gets height information for height data field
	 * *******************************************************/
	public int getHeight() {
		return height;
	}

	/********************************************************
	 *  gets width information for width data field
	 * ******************************************************/
	public int getWidth() {
		return width;
	}

	/****************************************************
	 *  computes the perimeter of the current rectangle
	 *  object requested.
	 *  @return perimeter of rectangle
	 * **************************************************/
	public int perimeter() {
		return 2 * width + 2 * height;
	}
	
	/*************************************************
	 *   retrieves state information as a string
	 * ***********************************************/
	@Override
	public String toString() {
		return "(" + width + ", " + height + ")";
	}

}
