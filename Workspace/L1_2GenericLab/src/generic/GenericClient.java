package generic;

public class GenericClient {
	public static void main(String[] args) {
		Generic<Point> p1  = new Generic<Point>(new Point(3,5));
		Generic<String> s1 = new Generic<String>("I am a String that uses the Generic class");
		Generic<Double> d1 = new Generic<Double>(6.08);
		
		System.out.println(p1);
		System.out.println(p1.hashCode());
		System.out.println();
		
		System.out.println(s1);
		System.out.println(s1.hashCode());
		System.out.println();
		
		System.out.println(d1);
		System.out.println(d1.hashCode());
	}
}
