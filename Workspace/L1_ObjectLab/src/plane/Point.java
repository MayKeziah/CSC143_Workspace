package plane;

/******************************************************************
 * <p> A point representing a location (x, y) in coordinate space, 
 *     specified in integer precision.
 ******************************************************************/

public class Point {

	/***********************************************
	 * 	data fields
	 * 	stores the (x, y) location of point
	 ***********************************************/
	private int x;
	private int y;
	
	/*****************************************************************
	 *	constructs and initializes a point at the origin (0,0)
	 * 	of the coordinate plane.
	 *****************************************************************/
	public Point() {
		this(0,0);					// calls constructor Point(int, int)
	}
	
	/******************************************************************
	 * 	constructs and initializes the point to the location specified
	 * 	by point p.
	 * 	@param p reference to the specified point object.
	 ******************************************************************/
	public Point(Point p) {
		setLocation(p);				// reduce redundancy with setLocation
	}
	
	/*****************************************************************
	 * 	constructs and initializes the point to the specified (x,y)
	 * 	location.
	 * 	@param x the x coordinate of point to construct.
	 * 	@param y the y coordinate of point to construct.
	 *****************************************************************/
	public Point(int x, int y) {
		setLocation(x, y);			// reduce redundancy with setLocation
	}
	
	/********************************************************************
	 * 	returns the x coordinate of the point in integer precision.
	 * 	@return x the x coordinate of point object.
	 ********************************************************************/
	public int getX() {
		return x;
	}
	
	/********************************************************************
	 * 	returns the y coordinate of the point in integer precision.
	 * 	@return y the y coordinate of point object.
	 ********************************************************************/
	public int getY() {
		return y;
	}
	
	/**********************************************************************
	 * 	moves the point to the specified location in the (x, y) coordinate
	 *  plane. This method is identical to setLocation(int, int).
	 * 	@param x the specified x coordinate value.
	 * 	@param y the specified y coordinate value.
	 **********************************************************************/
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*********************************************************************
	 * 	changes the location of the point in the coordinate plane to the 
	 *  location specified by point p. 
	 * 	@param p the specified point .
	 *********************************************************************/
	public void setLocation(Point p) {
		x = p.x;
		y = p.y;
	}
	
	/*********************************************************************
	 * 	changes the location of the point in the coordinate plane to the 
	 *  location specified by the values (x, y). 
	 * 	@param x the specified x coordinate value.
	 * 	@param y the specified y coordinate value.
	 *********************************************************************/
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/********************************************************************
	 * 	returns string representation of point.
	 * 	@return point (x, y) coordinates.
	 ********************************************************************/
	public String toString() {
		return "(" + x +  ", " + y + ")";
	}
	
	/********************************************************************
	 * 	translates the point at the location (x,y) by dx along the 
	 *  x-axis and dy along the y-axis, resulting with the point at 
	 *  location (x + dx, y + dy).
	 * 	@param dx the specified x coordinate value.
	 * 	@param dy the specified y coordinate value.
	 ********************************************************************/
	public void translate(int dx, int dy) {
		x += dx;		// x = x + dx
		y += dy;		// y = y + dy
	}
	
}
