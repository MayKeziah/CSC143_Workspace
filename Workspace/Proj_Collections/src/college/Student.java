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
	
	
	public Student() {
		this(null, 0, null, null, 0.0);
	}
	
	public Student(String name, int age, Rank rank, Major major, double gpa) {
		this.name 	= name;
		this.age 	= age;
		this.rank 	= rank;
		this.major 	= major;
		this.gpa 	= gpa;
	}
	
	public Student(Builder builder) {
		this.name 	= builder.name;
		this.age 	= builder.age;
		this.rank 	= builder.rank;
		this.major 	= builder.major;
		this.gpa 	= builder.gpa;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(Major major) {
		this.major = major;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
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
