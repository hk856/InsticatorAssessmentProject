public abstract class Person {
	private String FirstName;
	private String LastName;
	private String DateOfBirth;
	private String PhoneNum;

	/** DOB in the format of mm-dd-yyyy **/
	public Person(String FirstName, String LastName, String DateOfBirth, String PhoneNum) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.DateOfBirth = DateOfBirth;
		this.PhoneNum = PhoneNum;
	}

	public String getFirstName() {
		return this.FirstName;
	}

	public String getLastName() {
		return this.LastName;
	}

	public String getFullName() {
		String fullname = "";
		fullname = this.FirstName + " " + this.LastName;
		return fullname;
	}

	public String getPhoneNum() {
		return this.PhoneNum;
	}

	public String getDateOfBirth() {
		return this.DateOfBirth;
	}

	public abstract int getAge();

}
