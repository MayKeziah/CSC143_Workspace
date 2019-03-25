/**
 * 
 */
package college;

import utility.Comparable;
/**
 * An stores information about a student.
 * Allows students to be compared by several factors including age, name, and GPA.
 * 
 * @version 1.0
 * @author E
 */
public class Student implements Comparable<Student> {
	final private String name;
	final private int age;
	final private Rank rank; //Class Level
	final private Major major; //Area of study
	final private double gpa;
	
	public Student(Builder builder) {
		this.name 	= builder.name;
		this.age 	= builder.age;
		this.rank 	= builder.rank;
		this.major 	= builder.major;
		this.gpa 	= builder.gpa;
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
		public Builder setGPA(double gpa) {
			this.gpa = gpa;
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
		return s1.getFirstName().compareTo(s2.getFirstName());
	}	
	
	/**
	 * @param s1 a student to compare.
	 * @param s2 the student to compare to s1.
	 * @return 1 if the first student's GPA is greater than the second, 0 is they are equal, and otherwise, -1.
	 */
	public static int compareByGPA(Student s1, Student s2) {
		if (s1.getGPA() > s2.getGPA()) { // s1 is older
			return 1;
		} if (s1.getGPA() == s2.getGPA()) { // Same age
			return 0;
		} return -1; // s1 is younger
	}
	
	/**
	 * @param stud the student to compare to this student.
	 * @return 1 if the student's last name is greater than the passed student, 0 is they are the same, and otherwise, -1.
	 */
	public int compareTo(Student stud) {
		int lastName = getLastName().compareTo(stud.getLastName());
		if (lastName == 0) {
			return getFirstName().compareTo(stud.getFirstName());
		}
		return lastName;
	}
	
	/**
	 * @param other the object to compare to the this object.
	 * @return returns true if the object passed is a Student object and has the same stored information as the current Student.
	 */
	public boolean equals(Object other) {
		if (  !(other instanceof Student)
			|| (compareByAge	  (this, (Student) other) != 0)
			|| (compareByFirstName(this, (Student) other) != 0)
			|| (compareByGPA	  (this, (Student) other) != 0)
			|| (compareTo		  	    ((Student) other) != 0)  ) 
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
	 * @return the first name
	 */
	public String getFirstName() {
		return name.split(" ")[0];
	}

	/**
	 * @return the GPA
	 */
	public double getGPA() {
		return gpa;
	}

	/**
	 * @return the last name
	 */
	public String getLastName() {
		if(name.split(" ").length > 1) {
			return name.split(" ")[1];
		}else {
			return "UNKNOWN";
		}
	}

	/**
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}

	/**
	 * @return the full name
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
	 * @return whether the student is on the deans list
	 */
	public boolean isOnDeansList() {
		return gpa >= 3.8;
	}	

	/**
	 * @return whether the student is on the deans list
	 */
	public boolean isOnProbation() {
		return gpa < 2.0;
	}	
	
//	/**
//	 * @param age the age to set
//	 */
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	/**
//	 * @param gpa the gpa to set
//	 */
//	public void setGpa(double gpa) {
//		this.gpa = gpa;
//	}
//
//	/**
//	 * @param major the major to set
//	 */
//	public void setMajor(Major major) {
//		this.major = major;
//	}
//
//	/**
//	 * @param name the name to set
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	/**
//	 * @param rank the rank to set
//	 */
//	public void setRank(Rank rank) {
//		this.rank = rank;
//	}
	
	/**
	 * @return a file-ready string presenting information about this student.
	 */
	public String toFile() {
		return name + "," + age + "," + major + "," + rank + "," + gpa; //TODO
	}	
	
	/**
	 * @return a neatly formatted string presenting information about this student for a user.
	 */
	public String toString() {
		String major = this.major.toString();
		if (major.equals("COMPUTERSCIENCE")) {
			major = "COMPUTER SCIENCE";
		}
		return 
				"\nName:\t" + name +
				"\nAge:\t" + age +
				"\nRank:\t" + rank +
				"\nMajor:\t" + major + 
				"\nGPA:\t" + gpa +
				"\nDeans List:\t" + isOnDeansList() + 
				"\nOn Probation:\t" + isOnProbation(); 
	}

}
