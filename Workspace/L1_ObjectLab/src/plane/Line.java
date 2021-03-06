package plane;

/**
 * Line: a class to represent a line segment
 * */
public class Line {
	
	private Point p1; //Represents one location in coordinate space.
	private Point p2; //Represents another location in coordinate space.
	
	/**
	 * Constructor: default, set to (0, 0)  (1, 1).
	 * */
	public Line() {
		this(0, 0, 1, 1);
	}
	
	/**
	 * Constructor: passed 4 integers
	 * @param x1 the first X value to set
	 * @param y1 the first Y value to set
	 * @param x2 the second X value to set
	 * @param y2 the second Y value to set
	 * */
	public Line(int x1, int y1, int x2, int y2) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
	}

	/**
	 * Constructor: passed two points
	 * @param p1 the first point to set
	 * @param p2 the second point to set
	 * */
	public Line(Point p1, Point p2) {
		setEndPoints(p1, p2);
	}

	/**
	 * @return the p1
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 * @return the p2
	 */
	public Point getP2() {
		return p2;
	}
	
	/**
	 * @param p the point to test
	 * @return Boolean representing if the points are collinear (true) or not (false).
	 */
	public boolean isCollinear(Point p) {
		Line test = new Line(p1, p);
		if (this.slope() == test.slope()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @return double representing the length of the line.
	 * */
	public double magnitude() {
		int dx = p2.getX() - p1.getX();
		int dy = p2.getY() - p1.getY();
		return Math.sqrt(Math.abs(Math.pow(dx, 2) - Math.pow(dy, 2)));
	}
	
	/**
	 * @param p1 the p1 to set
	 * @param p2 the p2 to set
	 */
	public void setEndPoints(Point p1, Point p2) {
		setP1(p1);
		setP2(p2);
	}
	
	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	
	/**
	 * @return the slope of this line.
	 * */
	public double slope() throws ArithmeticException {
		int dy = p2.getY() - p1.getY();
		int dx = p2.getX() - p1.getX();
		if (dx == 0) {
			throw new ArithmeticException("Slope undefined: Division by zero.");
		}
		else {
			return (dy * 1.0) / dx;
		}
	}
	
	/**
	 * @return a string representation of the line.
	 * */
	public String toString() {
		return "[" + p1.toString() + " , " + p2.toString() + "]";
	}
	
	/**
	 * @param dx the distance (integer) and direction (+/-) to translate both end point x values
	 * @param dy the distance (integer) and direction (+/-) to translate both end point y values 
	 * */
	public void translate(int dx, int dy) {
		p1.translate(dx, dy);
		p2.translate(dx, dy);
	}
	
	
	

}
