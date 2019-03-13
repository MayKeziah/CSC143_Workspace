/**
 * 
 */
package college;

/**
 * @author E
 *
 */
public class Student {
	private String name;
	private int age;
	private Rank rank;
	private Major major;
	private double gpa;
	
	public Student(Builder builder) {
		this.name 	= builder.name;
		this.age 	= builder.age;
		this.rank 	= builder.rank;
		this.major 	= builder.major;
		this.gpa 	= builder.gpa;
	}

	/**
	 * @param s1 a student to compare.
	 * @param s2 the student to compare to s1.
	 * @return 1 if the s1 is older than s2, 0 is they are the same age, and otherwise -1.
	 */
	public static int compareByAge(Student s1, Student s2) {
		if (s1.getAge() > s2.getAge()) { // s1 is older
			return 1;
		} if (s1.getAge() == s2.getAge()) { // Same age
			return 0;
		} return -1; // s1 is younger
	}
	
	/**
	 * @param s1 a student to compare.
	 * @param s2 the student to compare to s1.
	 * @return 1 if the first student's first name comes alphabetically before than the second, 0 is they are the same, and otherwise, -1.
	 */
	public static int compareByFirstName(Student s1, Student s2) {
		if (s1.getFirstName() > s2.getFirstName()) { // s1 is older
			return 1;
		} if (s1.getFirstName() == s2.getFirstName()) { // Same age
			return 0;
		} return -1; // s1 is younger
	}	
	
	/**
	 * @param s1 a student to compare.
	 * @param s2 the student to compare to s1.
	 * @return 1 if the first student's GPA is greater than the second, 0 is they are equal, and otherwise, -1.
	 */
	public static int compareByGPA(Student s1, Student s2) {
		return 0; //TODO
	}
	
	/**
	 * @param stud the student to compare to this student.
	 * @return 1 if the student's last name is greater than the passed student, 0 is they are the same, and otherwise, -1.
	 */
	public int compareTo(Student stud) {
		return 0; //TODO
	}
	
	/**
	 * @param other the object to compare to the this object.
	 * @return returns true if the object passed is a Student object and has the same stored information as the current Student.
	 */
	public boolean equals(Object other) {
		if (   (compareByAge	  (this, (Student) other) != 0)
			&& (compareByFirstName(this, (Student) other) != 0)
			&& (compareByGPA	  (this, (Student) other) != 0)
			&& (compareTo		  		((Student) other) != 0)) 
		{
			return false;
		}
		return true;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the student's first name
	 */
	public String getFirstName() {
		return ""; //TODO
	}

	/**
	 * @return the GPA
	 */
	public double getGPA() {
		return gpa;
	}

	/**
	 * @return the student's first name
	 */
	public String getLastName() {
		return ""; //TODO
	}

	/**
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(Major major) {
		this.major = major;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public static class Builder{
		private String 	name;
		private int 	age;
		private Rank 	rank;
		private Major 	major;
		private double 	gpa;
		
		public Builder() {
			this.name 	= null;
			this.age 	= 0;
			this.rank 	= null;
			this.major 	= null;
			this.gpa 	= 0.0;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setAge(int age) {
			this.age = age;
			return this;
		} 
		public Builder setRank(Rank rank) {
			this.rank = rank;
			return this;
		}
		public Builder setMajor(Major major) {
			this.major = major;
			return this;
		}
		public Student build() {
			return new Student(this);
		}
		
	} //END INNER CLASS

}
