package generic;


public class GenericClient {
	public static void main(String[] args) {
		GenericFace p1  = new Generic<Point>(new Point(3,5));
		GenericFace s1 = new Generic<String>("I am a String that uses the Generic class");
		GenericFace d1 = new Generic<Double>(6.08);
		GenericFace[] list = {p1, s1, d1};
		for (GenericFace i: list) {
			System.out.println("----------------------------------------------");
			System.out.println("To String: " + i);
			System.out.println("Hash code: " + i.hashCode());
		}
		System.out.println("----------------------------------------------");
	}
}
